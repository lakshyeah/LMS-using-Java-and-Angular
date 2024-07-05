package com.lms.service;

import java.util.List;

import javax.validation.Valid;

import com.lms.dao.Member;

public interface MemberService {

	public Member addMember(@Valid Member member);

	public List<Member> getAllMembers();

	public Member getMemberById(Integer memberid);

	public List<Member> deleteMemberById(Integer memberid);

	public boolean doesMemberExist(int memberid);
	
	public Member updateMember(Member member, Integer id);
}

