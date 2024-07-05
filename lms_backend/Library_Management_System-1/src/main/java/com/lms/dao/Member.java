package com.lms.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Member {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer memberid;
	
	@Column(name="membername", length=60)
	@NotBlank(message="Member name should not be blank")
	private String membername;
	
	@Column(name="phoneno", length=10)	
	@NotBlank(message="Phoneno should not be blank")
	private String phoneno;

	@Column(name="address", length=150)	
	@NotBlank(message="Address should not be blank")
	private String address;
	
	@Column(name="emailid", length=50)	
	@NotBlank(message="Email address should not be blank")	
	private String emailid;
	
	@Column(name="standard", length=15)	
	@NotBlank(message="Standard should not be blank")		
	private String standard;
	
	@Column(name="course", length=50)	
	@NotBlank(message="Course should not be blank")		
	private String course;

	
	public Member() {
		super();
	}
	


	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", membername=" + membername + ", phoneno=" + phoneno + ", address="
				+ address + ", emailid=" + emailid + ", standard=" + standard + ", course=" + course + "]";
	}
	
	
	
	
}

