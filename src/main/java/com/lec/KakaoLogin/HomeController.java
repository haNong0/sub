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
			System.out.println(session);
		}
		//session안에 userId정보를 담는 코드
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


	
//	@RequestMapping(value="/logout")
//	public ModelAndView logout(HttpSession session) {
//		ModelAndView mav = new ModelAndView();
//		kakaoApi.kakaoLogout((String)session.getAttribute("accessToken"));
//		System.out.println("로그아웃기능 구현");
//		System.out.println("accessToken:" + (String)session.getAttribute("accessToken"));
//		session.removeAttribute("accessToken");
//		session.removeAttribute("userId");
////		session.invalidate();
//		System.out.println("after accessToken:" + (String)session.getAttribute("accessToken"));
//		mav.setViewName("/login/login");
//		return mav;
//	}
	 @RequestMapping(value="/logout")
	 public String logout(HttpSession session) {
		 kakaoApi.kakaoLogout((String)session.getAttribute("access_Token"));
	     session.removeAttribute("access_Token");
	     session.removeAttribute("userId");
	     session.invalidate();
	     return "index";
	 }
//	 @RequestMapping(value = "/logout")
//	    public ModelAndView logout(HttpSession session) {
//	        ModelAndView mav = new ModelAndView();
//	        
//	        // 세션에서 사용자 정보 삭제
//	        session.removeAttribute("userId");
//	        session.removeAttribute("accessToken");
//	        
//	        // 카카오 API를 통해 카카오 계정 로그아웃 요청
//	        String logoutRedirectUri = "http://localhost:8089/login";
//	        String clientId = "452560c68b8f6c479009e34bf648c561";
//	        String logoutUrl = "https://kauth.kakao.com/oauth/logout?client_id=452560c68b8f6c479009e34bf648c561&logout_redirect_uri=http://localhost:8089/login";
//	        
//	        // 서비스 로그아웃 처리를 위해 Logout Redirect URI로 리다이렉트
//	        mav.setViewName("redirect:http://localhost:8089/login");
//	        return mav;
//	    }
	}



	
	
	

