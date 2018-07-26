package com.springSecurity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springSecurity.bean.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired 
	private DataSource dataSource;
	
	public User getUser(int id) {
	
		String query = "select * from Users where userID=?";
		Connection conn = null;
	
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			
			User user = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				
				user.setFullname(rs.getString("fullname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("userpassword"));
				user.setUserID(rs.getInt("userID"));
				user.setUserType(rs.getBoolean("userType"));
			}
			rs.close();
			ps.close();
			 
			return user;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					
				}
			}
		}
		
	}

	public void saveUser(User user) {
		String query="insert into users(userid,userpassword,username,fullname,usertype) values (?,?,?,?,?)";
		Connection conn = null;
		
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, user.getUserID());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getUsername());
			ps.setString(4,user.getFullname());
			ps.setBoolean(5, user.isUserType());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	public User updateUser(int id, User user) {
		System.out.println("update");
		return null;
	}

	public void deleteUser(int id) {
		System.out.println("delete");
		String query="delete from users where userID=?";
		Connection conn=null;
		try{
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			throw new RuntimeException(e);	
			
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
				}
			}
		}
		
	}



}
