package com.lms.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionid;
	
	@Column(name="operation")
	private String operation;
	
	@Column(name="transdate")
	private String transdate;
	
//	@Column(name="bookid")
//	private Integer bookid;
//	
//	@Column(name="memberid")
//	private Integer memberid;
	
	
	public Transaction() {
		super();
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getTransdate() {
		return transdate;
	}

	public void setTransdate(String transdate) {
		this.transdate = transdate;
	}

//	public Integer getBookid() {
//		return bookid;
//	}
//
//	public void setBookid(Integer bookid) {
//		this.bookid = bookid;
//	}
//
//	public Integer getMemberid() {
//		return memberid;
//	}
//
//	public void setMemberid(Integer memberid) {
//		this.memberid = memberid;
//	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", operation=" + operation + ", transdate=" + transdate;
	}
	
	//+ ", bookid=" + bookid + ", memberid=" + memberid + 
	
}

