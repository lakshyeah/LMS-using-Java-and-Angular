package com.lms.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dao.BooksList;
import com.lms.service.BooksListService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BooksListController {
	
	@Autowired
	private BooksListService booksListService;


	@PostMapping("/addBooksList")
	public BooksList addBooksList(@Valid @RequestBody BooksList booksList) {
		return booksListService.addBooksList(booksList);	
	}
	
	@GetMapping("/getBooksLists")
	public List<BooksList> getAllBooksLists(){
		return booksListService.getAllBooksLists();
	}

	@GetMapping("/getBookByBookname/{bname}")
	public Optional<BooksList> getBookByBookname(@PathVariable("bname") String bookname){
		return booksListService.getBookByBookname(bookname);
	}
	
	
	 @PutMapping("/updateQuantity/{bookname}/{quantity}")
	    public ResponseEntity<BooksList> updateQuantity(@PathVariable String bookname, @PathVariable int quantity) {
	        BooksList updatedBooksList = booksListService.updateQuantity(bookname, quantity);
	        
	        if (updatedBooksList != null) {
	            return ResponseEntity.ok(updatedBooksList);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	 
		@PutMapping("/reducequantitybyone/{bookname}")
		public ResponseEntity<BooksList> reducequantitybyone(@PathVariable String bookname) {
			BooksList updatedBookquantity =  booksListService.reducequantitybyone(bookname);
			
			if (updatedBookquantity != null) {
				return ResponseEntity.ok(updatedBookquantity);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}

}