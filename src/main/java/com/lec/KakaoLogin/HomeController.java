package com.lec.KakaoLogin;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

	KakaoAPI kakaoApi = new KakaoAPI();
	
	 @RequestMapping  (value="/auth/kakao/callback")
	public ModelAndView login(@RequestParam("code") String code, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// 1번 인증코드 요청 전달
		String accessToken = kakaoApi.getAccessToken(code);
		// 2번 인증코드로 토큰 전달
		HashMap<String, Object> userInfo = kakaoApi.getUserInfo(accessToken);
		
		System.out.println("login info : " + userInfo.toString());
		
		if(userInfo.get("email") != null) {
			session.setAttribute("userId", userInfo.get("email"));
			session.setAttribute("accessToken", accessToken);
		}
		mav.addObject("userId", userInfo.get("email"));
		mav.setViewName("product/kakaopdinfo");
		return mav;
	}

//	//code를 확인 할수 있는 함수
//	@GetMapping("/auth/kakao/callback") 
//		public @ResponseBody String kakaoCallback(String code) {
//			return "카카오 로그인 인증 : " + code;
//		}
//		
//	}


	
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		kakaoApi.kakaoLogout((String)session.getAttribute("accessToken"));
		session.removeAttribute("accessToken");
		session.removeAttribute("userId");
		mav.setViewName("index");
		return mav;
	}
}
	
	
	

