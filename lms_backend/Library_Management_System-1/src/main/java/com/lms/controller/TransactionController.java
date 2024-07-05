package com.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dao.Transaction;
import com.lms.service.TransactionService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;


	@PostMapping("/addTransaction")
	public Transaction addTransaction(@Valid @RequestBody Transaction transaction) {
		return transactionService.addTransaction(transaction);	
	}
	
	@GetMapping("/getAllTransactions")
	public List<Transaction> getAllTransactions(){
		return transactionService.getAllTransactions();
	}
	
	@GetMapping("/getTransactionById/{tid}")
	public Transaction getTransactionById(@PathVariable("tid") Integer transactionid){
		return transactionService.getTransactionById(transactionid);
	}
	
	@DeleteMapping("/deleteTransactionById/{tid}")
	public List<Transaction> deleteTransactionById(@PathVariable ("tid") Integer transactionid) {
		return transactionService.deleteTransactionById(transactionid);	
	}

}