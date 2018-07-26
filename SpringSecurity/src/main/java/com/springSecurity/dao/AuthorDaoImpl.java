package com.springSecurity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springSecurity.bean.Author;


@Repository
public class AuthorDaoImpl implements AuthorDao{

	@Autowired 
	private DataSource dataSource;
	
	public Author getAuthor(int id) {
		String query = "select * from Author where authorID=?";
		Connection conn = null;
	
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			
			Author author = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				author = new Author();
				author.setAuthorID(rs.getInt("AuthorID"));
				author.setFullname(rs.getString("AuthorName"));
			}
			rs.close();
			ps.close(); 
			return author;
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
	public void saveAuthor(Author author) {
		String query="insert into author(authorid,fullname) values (?,?)";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, author.getFullname());
			ps.setInt(2, author.getAuthorID());
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

	public void deleteAuthor(int id) {
		// TODO Auto-generated method stub
		System.out.println("deleteAuthor");
		
	}

}
