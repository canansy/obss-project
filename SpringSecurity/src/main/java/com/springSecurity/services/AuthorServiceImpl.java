package com.springSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springSecurity.bean.Author;
import com.springSecurity.dao.AuthorDao;

@Service
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	private AuthorDao authorDao;
	
	public Author getAuthor (int id) {
		return authorDao.getAuthor(id);
	}

	public void saveAuthor(Author author) {
		// TODO Auto-generated method stub
		authorDao.saveAuthor(author);
		
	}

	public void deleteAuthor(int id) {
		authorDao.deleteAuthor(id);
		
	}

}
