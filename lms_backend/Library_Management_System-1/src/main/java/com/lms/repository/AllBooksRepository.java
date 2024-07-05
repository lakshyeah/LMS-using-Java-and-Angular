package com.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lms.dao.AllBooks;

@Repository
public interface AllBooksRepository extends JpaRepository<AllBooks, Integer> {
	//"SELECT COUNT(b) FROM Book b WHERE b.bookId = :bookId AND b.availability = 'yes'"
//	@Query(value = "SELECT COUNT(b) FROM all_books b WHERE b.bookid = :bookId AND availability='yes'", nativeQuery = true)
//    boolean checkbookAvailability(@Param("bookId") Integer bookId);;
    
    @Query(value = "SELECT * FROM all_books WHERE bookid = :bookid AND availability='yes'", nativeQuery = true)
    List<AllBooks> checkbookAvailability(@Param("bookid") Integer bookid);

    Optional<AllBooks> findByBookid(int bookid);
}
