package com.lms.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class BooksList {
	
	@Id
	@Column(name="bookname", length=60)
	private String bookname;
	
	@Column(name="totalquantity")
	@Min(0)
	private int totalquantity;

	@Column(name="availablequantity")
	@Min(0)
	private int availablequantity;
	
	@Column(name="authorname", length=30)
	private String authorname;
	
	@Column(name="publisher", length=30)
	private String publisher;
	
	@Column(name="category", length=30)
	private String category;
	
	@Column(name="booktopic", length=40)
	private String booktopic;

	public BooksList() {
		super();
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getTotalquantity() {
		return totalquantity;
	}

	public void setTotalquantity(int totalquantity) {
		this.totalquantity = totalquantity;
	}

	public int getAvailablequantity() {
		return availablequantity;
	}

	public void setAvailablequantity(int availablequantity) {
		this.availablequantity = availablequantity;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBooktopic() {
		return booktopic;
	}

	public void setBooktopic(String booktopic) {
		this.booktopic = booktopic;
	}

	@Override
	public String toString() {
		return "BooksList [bookname=" + bookname + ", totalquantity=" + totalquantity + ", availablequantity="
				+ availablequantity + ", authorname=" + authorname + ", publisher=" + publisher + ", category="
				+ category + ", booktopic=" + booktopic + "]";
	}


	
	
	
}
