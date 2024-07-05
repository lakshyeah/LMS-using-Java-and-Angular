package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.AllBooks;
import com.lms.dao.BooksList;
import com.lms.repository.BooksListRepository;

@Service
public class BooksListServiceImpl implements BooksListService {
	@Autowired
	private BooksListRepository booksListRepository;
	
	@Override
	public BooksList addBooksList(BooksList booksList) {
		return booksListRepository.save(booksList);
	}

	@Override
	public List<BooksList> getAllBooksLists() {
		return booksListRepository.findAll();
	}

	@Override
	public Optional<BooksList> getBookByBookname(String bookName) {
		return booksListRepository.getBookByBookname(bookName);
	}

	public BooksList updateQuantity(String bookname, int quantity) {
        Optional<BooksList> optionalBooksList = booksListRepository.getBookByBookname(bookname);

        if (optionalBooksList.isPresent()) {
            BooksList booksList = optionalBooksList.get();
            booksList.setTotalquantity(booksList.getTotalquantity() + quantity);
            booksList.setAvailablequantity(booksList.getAvailablequantity() + quantity);
            return booksListRepository.save(booksList);
        }

        return null; // Or throw an exception depending on your requirements
    }

	@Override
	public BooksList reducequantitybyone(String bookname) {
		Optional<BooksList> optionalBooksList = booksListRepository.getBookByBookname(bookname);

        if (optionalBooksList.isPresent()) {
            BooksList booksList = optionalBooksList.get();
            booksList.setAvailablequantity(booksList.getAvailablequantity() - 1);
            return booksListRepository.save(booksList);
        }

        return null; // Or throw an exception depending on your requirements
		
	}

}

