package com.app.UserBookAppl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.UserBookAppl.model.book.Book;
import com.app.UserBookAppl.service.BookService;

@RestController
@RequestMapping("/book/api")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/add")
	public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
		Book nwBook = bookService.addBook(book);
		return new ResponseEntity<Book>(nwBook, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Book>> getAllBookDtls() {
		List<Book> bookList = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}

}
