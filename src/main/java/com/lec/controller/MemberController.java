package com.lec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.lec.domain.Member;
import com.lec.service.MemberService;

@Controller

public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/insertMember")
	public String insertMemberForm(Member member) {
		return "Member/insertMember";
	}

	
	@PostMapping("/insertMember")
	public String insertMember(Member member) {
		
		if(member.getId() == null) {
			return "redirect:index";
		}
		member.setRole(member.getRole() != null ? "ADMIN" : "USER");
		memberService.insertMember(member);
		
		return "redirect:login";
	}
}
