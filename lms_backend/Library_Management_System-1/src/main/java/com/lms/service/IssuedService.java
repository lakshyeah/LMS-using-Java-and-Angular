package com.lms.service;

import java.util.List;

import javax.validation.Valid;

import com.lms.dao.Issued;

public interface IssuedService {

	public Issued addIssued(@Valid Issued issued);

	public List<Issued> getAllIssued();

	public Issued getIssuedById(Integer issuedid);

}
