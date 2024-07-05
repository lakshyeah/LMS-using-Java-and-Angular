package com.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lms.dao.BooksList;

@Repository
public interface BooksListRepository extends JpaRepository<BooksList, Integer>{

    @Query(value = "SELECT * FROM books_list WHERE bookname = :bookName", nativeQuery = true)
    Optional<BooksList> getBookByBookname(@Param("bookName") String bookName);

	
}
