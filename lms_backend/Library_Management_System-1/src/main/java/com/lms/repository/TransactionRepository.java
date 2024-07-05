package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.dao.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
