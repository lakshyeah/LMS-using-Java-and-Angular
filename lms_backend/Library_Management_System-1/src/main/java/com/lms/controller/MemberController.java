package com.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dao.Member;
import com.lms.service.MemberService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MemberController {

	@Autowired
	private MemberService memberService;


	@PostMapping("/addMember")
	public Member addMember(@Valid @RequestBody Member member) {
		return memberService.addMember(member);	
	}
	
	@GetMapping("/getAllMembers")
	public List<Member> getAllMembers(){
		return memberService.getAllMembers();
	}
	
	@GetMapping("/getMemberById/{mid}")
	public Member getMemberById(@PathVariable("mid") Integer memberid){
		return memberService.getMemberById(memberid);
	}
	
	@DeleteMapping("/deleteMemberById/{mid}")
	public List<Member> deleteMemberById(@PathVariable ("mid") Integer memberid) {
		return memberService.deleteMemberById(memberid);	
	}

	@GetMapping("/memberexists/{memberid}")
    public ResponseEntity<Boolean> doesMemberExist(@PathVariable int memberid) {
        boolean exists = memberService.doesMemberExist(memberid);
        return ResponseEntity.ok(exists);
    }

    @PutMapping("/updateMember/{id}")
    public Member updateMember(@PathVariable("id") Integer id,@RequestBody Member member)
    {
    	return memberService.updateMember(member,id);
    }

	
}
