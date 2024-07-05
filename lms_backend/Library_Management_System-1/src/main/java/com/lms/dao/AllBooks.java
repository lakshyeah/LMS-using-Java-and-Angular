package com.lms.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AllBooks {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookid;
	
	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}


	@Column(name="bookname", length=60)
	private String bookname;
	
	@Column(name="availability", length=50)
	private String availability;
	
	@Column(name="booktopic", length=60)
	private String booktopic;
	
	@Column(name="price")
	private float price;
	
	@Column(name="description", length=60)
	private String description;
	
	@Column(name="edition", length=30)
	private String edition;

	
	
	public AllBooks() {
		super();
	}

	
	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getBooktopic() {
		return booktopic;
	}

	public void setBooktopic(String booktopic) {
		this.booktopic = booktopic;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}



	@Override
	public String toString() {
		return "AllBooks [bookid=" + bookid + ", bookname=" + bookname + ", availability=" + availability
				+ ", booktopic=" + booktopic + ", price=" + price + ", description=" + description + ", edition="
				+ edition + "]";
	}
	

	
	
}
