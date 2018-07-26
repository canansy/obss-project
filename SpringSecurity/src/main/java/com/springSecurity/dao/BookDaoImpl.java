package com.springSecurity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springSecurity.bean.Book;

@Repository
public class BookDaoImpl implements BookDao{

	@Autowired 
	private DataSource dataSource;
	
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		System.out.println("deleteBook");
		
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		//String query="insert into book values (?,?,?,?,?,?)";
		String query="insert into book (bookid,price,available,publishername,authorID,title) values (?,?,?,?,?,?)";
		Connection conn = null;
		
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1,book.getBookID());
			ps.setInt(2, book.getPrice());
			ps.setBoolean(3, book.isAvailable());
			ps.setString(4, book.getPublishername());
			ps.setInt(5, book.getAuthorID());
			ps.setString(6, book.getTitle());
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

	public Book getBook(String inputTitle) {
		
		Book book = new Book();
		String query = "select * from Book where title=?";
		Connection conn = null;
		
		
		
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, inputTitle);
			ResultSet rs = ps.executeQuery();
			
			book.setBookID(0);
			book.setPrice(0);
			book.setAvailable(false);
			book.setPublishername(null);
			book.setAuthorID(0);
			book.setTitle(null);
			
			if(rs.next()){
				book = new Book();
				
				
				
				book.setBookID(rs.getInt("BookID"));
				book.setPrice(rs.getInt("Price"));
				book.setAvailable(rs.getBoolean("Available"));
				book.setPublishername(rs.getString("PublisherName"));
				book.setAuthorID(rs.getInt("AuthorID"));
				book.setTitle(rs.getString("Title"));
				

			}
			rs.close();
			ps.close();
			 
			return book;
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

}
