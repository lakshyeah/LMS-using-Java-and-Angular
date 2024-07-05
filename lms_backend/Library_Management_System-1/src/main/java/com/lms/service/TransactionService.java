package com.lms.service;

import java.util.List;

import javax.validation.Valid;

import com.lms.dao.Transaction;

public interface TransactionService {

	public Transaction addTransaction(@Valid Transaction transaction);

	public List<Transaction> getAllTransactions();

	public Transaction getTransactionById(Integer transactionid);

	public List<Transaction> deleteTransactionById(Integer transactionid);

}
