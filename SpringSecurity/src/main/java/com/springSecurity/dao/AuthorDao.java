package com.springSecurity.dao;

import com.springSecurity.bean.Author;

public interface AuthorDao {
	public Author getAuthor(int id);
	public void saveAuthor(Author author);
	public void deleteAuthor(int id);
}
