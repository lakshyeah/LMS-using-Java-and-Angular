package com.lms.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Issued {

	@Id
	@Column(name="bookid")
	private Integer bookid;	

	@Column(name="memberid")
	private Integer memberid;

	@Column(name="borrowdate")
	private String borrowdate;
	
	@Column(name="bookname", length=60)
	private String bookname;
	
	@Column(name="emailid", length=50)	
	private String emailid;
	
	@Column(name="course", length=50)
	private String course;
	
	@Column(name="standard", length=15)	
	private String standard;
	
	@Column(name="membername", length=40)
	private String membername;
	
	@Column(name="defaulter", length=5)		
	private String defaulter;
	
	@Column(name="phoneno", length=10)	
	private String phoneno;

	
	public Issued() {
		super();
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public String getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getDefaulter() {
		return defaulter;
	}

	public void setDefaulter(String defaulter) {
		this.defaulter = defaulter;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "Issued [memberid=" + memberid + ", bookid=" + bookid + ", borrowdate=" + borrowdate + ", bookname="
				+ bookname + ", emailid=" + emailid + ", course=" + course + ", standard=" + standard + ", membername="
				+ membername + ", defaulter=" + defaulter + ", phoneno=" + phoneno + "]";
	}
	
}


