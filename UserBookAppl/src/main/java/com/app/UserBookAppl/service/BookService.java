package com.app.UserBookAppl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.UserBookAppl.book.repository.IBookRepository;
import com.app.UserBookAppl.model.book.Book;

@Service
@Transactional
public class BookService {

	@Autowired
	private IBookRepository bookRepo;

	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
}
