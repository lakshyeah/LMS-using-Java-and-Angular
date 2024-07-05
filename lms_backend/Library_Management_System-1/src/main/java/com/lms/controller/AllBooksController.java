package com.lms.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dao.AllBooks;
import com.lms.service.AllBooksService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AllBooksController {
	
	@Autowired
	private AllBooksService allBooksService;


	@PostMapping("/addAllBooks")
	public AllBooks addAllBooks(@Valid @RequestBody AllBooks allbooks) {
		return allBooksService.addAllBooks(allbooks);	
	}
	
	@GetMapping("/getAllBooks")
	public List<AllBooks> getAllBooks(){
		return allBooksService.getAllBooks();
	}
	
	@GetMapping("/getBookById/{bid}")
	public AllBooks getDepartmentById(@PathVariable("bid") Integer bookid){
		return allBooksService.getAllBooksById(bookid);
	}
	
	
	@GetMapping("/checkBook/{bid}")
	public ResponseEntity<Boolean> checkbookAvailability(@PathVariable("bid") Integer bookid) {
	    Optional<AllBooks> optionalBook = allBooksService.findByBookid(bookid);

	    if (optionalBook.isPresent() && "yes".equalsIgnoreCase(optionalBook.get().getAvailability())) {
	        return ResponseEntity.ok(true);
	    } else {
	        return ResponseEntity.ok(false);
	    }
	}

	
//	@GetMapping("/checkBook/{bid}")
//	public List<AllBooks> checkbookAvailability(@PathVariable("bid") Integer bookid){
//		return allBooksService.checkbookAvailability(bookid);
//	}

	
	@DeleteMapping("/deleteBookById/{bid}")
	public List<AllBooks> deleteDepartmentById(@PathVariable ("bid") Integer bookid) {
		return allBooksService.deleteAllBooksById(bookid);	
	}
	
	
//	@GetMapping("/bookexists/{bookid}")
//    public ResponseEntity<Boolean> doesBookExist(@PathVariable int bookid) {
//        boolean exists = allBooksService.doesBookExist(bookid);
//        return ResponseEntity.ok(exists);
//    }
	
	@PutMapping("changeavailabilitytoNo/{bookid}")
	public ResponseEntity<AllBooks> changeavailabilitytoNo(@PathVariable("bookid") Integer bookid){
		AllBooks updatedavailability =  allBooksService.changeavailabilitytoNo(bookid);
		if (updatedavailability != null) {
			return ResponseEntity.ok(updatedavailability);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}