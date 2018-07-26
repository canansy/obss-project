package com.springSecurity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springSecurity.bean.Book;
import com.springSecurity.services.BookService;


@Controller
@ResponseBody
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Book> getBooks() {
		return Arrays.asList(new Book());
	}

	@GetMapping("/{title}")
	public Book getBook(@PathVariable String title) {
		return bookService.getBook(title);
	}

	@PostMapping
	public void saveBook(@RequestBody Book book) {
		System.out.println("ok");
		bookService.addBook(book);
		System.out.println("ok");	}


	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		bookService.deleteBook(id);
	}

}
