package com.app.UserBookAppl.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.UserBookAppl.model.book.Book;

@Repository
public interface IBookRepository  extends JpaRepository<Book, Long>{

}
