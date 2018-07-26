package com.springSecurity.services;

import com.springSecurity.bean.Author;


public interface AuthorService {
	public Author getAuthor(int id);
	public void saveAuthor(Author author);
	public void deleteAuthor(int id);
}
