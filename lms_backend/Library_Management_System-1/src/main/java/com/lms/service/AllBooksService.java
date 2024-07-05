package com.lms.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.lms.dao.AllBooks;
import com.lms.dao.BooksList;

public interface AllBooksService {

	public AllBooks addAllBooks(@Valid AllBooks allBooks);

	public List<AllBooks> getAllBooks();

	public AllBooks getAllBooksById(Integer bookid);

	public List<AllBooks> checkbookAvailability(Integer bookid);
	
	public List<AllBooks> deleteAllBooksById(Integer bookid);

	public Optional<AllBooks> findByBookid(Integer bookId);
	//public boolean doesBookExist(int bookid);

	public AllBooks changeavailabilitytoNo(Integer bookid);
	
}