package com.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.Transaction;
import com.lms.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction getTransactionById(Integer transactionid) {
		Transaction transaction =transactionRepository.findById(transactionid).get();
		return transaction;
	}

	@Override
	public List<Transaction> deleteTransactionById(Integer transactionid) {
		transactionRepository.deleteById(transactionid);
		return transactionRepository.findAll();
	}
}

