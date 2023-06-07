package com.lec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lec.domain.Member;
import com.lec.service.MemberService;

@Controller
@SessionAttributes("member")
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginView() {
		return "/login/login";

	}
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member findMember = memberService.getMember(member);
		if(findMember != null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", findMember);  // session과 request영역에서 동시에 저장
			return "product/getproductinfo";
		} else {
			return "redirect:login";
		}
	}
}