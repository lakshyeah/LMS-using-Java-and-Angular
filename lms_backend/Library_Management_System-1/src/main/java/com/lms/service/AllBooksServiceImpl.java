package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lms.dao.AllBooks;
import com.lms.repository.AllBooksRepository;

@Service
public class AllBooksServiceImpl implements AllBooksService{

	@Autowired
	private AllBooksRepository allBooksRepository;
	
	@Override
	public AllBooks addAllBooks(AllBooks allBooks) {
		return allBooksRepository.save(allBooks);
	}

	@Override
	public List<AllBooks> getAllBooks() {
		return allBooksRepository.findAll();
	}

	@Override
	public AllBooks getAllBooksById(Integer bookid) {
		AllBooks allbooks =allBooksRepository.findById(bookid).get();
		return allbooks;
	}

	@Override
	public List<AllBooks> deleteAllBooksById(Integer bookid) {
		allBooksRepository.deleteById(bookid);
		return allBooksRepository.findAll();
	}

	@Override
	public List<AllBooks> checkbookAvailability(Integer bookid) {
		return allBooksRepository.checkbookAvailability(bookid);
	}
	
//	@Override
//	public boolean doesBookExist(int bookid) {
//        return allBooksRepository.findByBookid(bookid).isPresent();
//    }
	
    public Optional<AllBooks> findByBookid(Integer bookId) {
        return allBooksRepository.findByBookid(bookId);
    }
	
	@Override
	public AllBooks changeavailabilitytoNo(Integer bookid) {
		Optional<AllBooks> allBooksList = allBooksRepository.findById(bookid);

        if (allBooksList.isPresent()) {
            AllBooks allbooksList = allBooksList.get();
            allbooksList.setAvailability("No");
            return allBooksRepository.save(allbooksList);
        }

        return null; // Or throw an exception depending on your requirements
		
	}

	
}