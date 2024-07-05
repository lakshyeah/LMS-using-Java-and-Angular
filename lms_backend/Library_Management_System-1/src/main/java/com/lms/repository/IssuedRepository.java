package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.dao.Issued;

@Repository
public interface IssuedRepository extends JpaRepository<Issued, Integer>{

}
