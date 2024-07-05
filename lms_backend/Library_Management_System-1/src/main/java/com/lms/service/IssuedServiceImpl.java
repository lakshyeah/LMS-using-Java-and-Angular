package com.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.Issued;
import com.lms.repository.IssuedRepository;

@Service
public class IssuedServiceImpl implements IssuedService {
	@Autowired
	private IssuedRepository issuedRepository;
	
	@Override
	public Issued addIssued(Issued issued) {
		return issuedRepository.save(issued);
	}

	@Override
	public List<Issued> getAllIssued() {
		return issuedRepository.findAll();
	}

	@Override
	public Issued getIssuedById(Integer issuedid) {
		Issued issued =issuedRepository.findById(issuedid).get();
		return issued;
	}

}
