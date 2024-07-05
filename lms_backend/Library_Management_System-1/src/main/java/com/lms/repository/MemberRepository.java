package com.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.dao.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	Optional<Member> findByMemberid(int memberid);
}
