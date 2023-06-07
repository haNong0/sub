package com.lec.service;

import org.springframework.stereotype.Service;

import com.lec.domain.Member;

public interface MemberService {
	
	Member getMember(Member member); //로그인정보를 가져오기
	void insertMember(Member member); // 로그인정보를 넣기
}
