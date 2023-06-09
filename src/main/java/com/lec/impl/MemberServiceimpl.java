package com.lec.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.domain.Member;
import com.lec.persistance.MemberRepository;
import com.lec.service.MemberService;
@Service
public class MemberServiceimpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	// db에서 사용자 정보를 비교하여 가져오는 메서드
	public Member getMember(Member member) {
		Optional<Member> findMember = memberRepository.findById(member.getId());
		if(findMember.isPresent()) 
			return findMember.get();
		else return null;
	}

	public void insertMember(Member member) {
		memberRepository.save(member);		
	}
		









	
}

