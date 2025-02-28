package com.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dao.BooksList;
import com.lms.dao.Issued;
import com.lms.service.IssuedService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IssuedController {
	
	@Autowired
	private IssuedService issuedService;


	@PostMapping("/addIssued")
	public Issued addIssued(@Valid @RequestBody Issued issued) {
		return issuedService.addIssued(issued);	
	}
	
	@GetMapping("/getAllIssued")
	public List<Issued> getAllIssued(){
		return issuedService.getAllIssued();
	}
	
	@GetMapping("/getIssuedById/{iid}")
	public Issued getIssuedById(@PathVariable("iid") Integer issuedid){
		return issuedService.getIssuedById(issuedid);
	}
	
}
