package com.springSecurity.dao;

import com.springSecurity.bean.Book;

public interface BookDao {

	public void deleteBook(int id);
	public void addBook(Book id);
	public Book getBook(String title);
	
}
