package com.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.Member;
import com.lms.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Member addMember(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	@Override
	public Member getMemberById(Integer memberid) {
		Member member =memberRepository.findById(memberid).get();
		return member;
	}

	@Override
	public List<Member> deleteMemberById(Integer memberid) {
		memberRepository.deleteById(memberid);
		return memberRepository.findAll();

	}

	@Override
	public boolean doesMemberExist(int memberid) {
		return memberRepository.findByMemberid(memberid).isPresent();
	}

	@Override
	public Member updateMember(Member member, Integer id) 
	{
		Member updatemember=memberRepository.findById(id).get();
		updatemember.setMembername(member.getMembername());
		updatemember.setPhoneno(member.getPhoneno());
		updatemember.setAddress(member.getAddress());
		updatemember.setEmailid(member.getEmailid());
		updatemember.setStandard(member.getStandard());
		updatemember.setCourse(member.getCourse());
		memberRepository.save(updatemember);
		return updatemember;
	}

}
