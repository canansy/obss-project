package com.springSecurity.services;

import com.springSecurity.bean.Book;


public interface BookService {
	
	public void deleteBook(int id);
	public void addBook(Book id);
	public Book getBook(String title);
	
	
}
