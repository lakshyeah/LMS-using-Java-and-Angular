package com.lms.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.lms.dao.BooksList;

public interface BooksListService {

	public BooksList addBooksList(@Valid BooksList booksList);

	public List<BooksList> getAllBooksLists();

	public Optional<BooksList> getBookByBookname(String bookName);

	public BooksList updateQuantity(String bookname, int quantity);
	
	public BooksList reducequantitybyone(String bookname);
}
