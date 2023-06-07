package com.lec.persistance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lec.domain.Member;
import com.lec.domain.Product;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	

	
}