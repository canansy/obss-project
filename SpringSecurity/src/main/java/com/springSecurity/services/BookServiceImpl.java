package com.springSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springSecurity.bean.Book;
import com.springSecurity.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {

	@Autowired 
	private BookDao bookDao;

	
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		bookDao.deleteBook(id);
		
	}

	public void addBook(Book id) {
		// TODO Auto-generated method stub
		bookDao.addBook(id);
	}

	public Book getBook(String title) {
		// TODO Auto-generated method stub
		return bookDao.getBook(title);
	}
	
}
