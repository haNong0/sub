package com.lec.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.domain.Member;
import com.lec.domain.Product;
import com.lec.persistance.ProductRepository;
import com.lec.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private  ProductRepository  productRepository;
	
	// 상품등록(get)
	@GetMapping("/addproduct")
	public String addproductForm (Product product) {
		return "product/addproduct";
		
	}
	
	// 상품등록(post)
	@PostMapping("/addproduct")
	public String addproduct(@ModelAttribute("product") Product product, Member member) {

		if(product.getId() == null) {
			return "redirect:getproductinfo";
		}
		
		productService.insertproduct(product);
		return "redirect:getproductinfo";
	}

	// 전체 상픔리스트를 조회하는 코드
	@GetMapping("/allproductlist")
   public String allproductList(HttpSession session,Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product/allproductlist"; // 전체상품목록으로 이동
   }
	
	// id별 상품리스트 조회
	@GetMapping("/getproductinfo")
	public String productList(HttpSession session, Model model) {
//	    String id = (String) session.getAttribute("id"); // 세션에서 id 정보를 가져옵니다.
	    Member member = (Member) session.getAttribute("member"); // 세션에서 id 정보를 가져옵니다.
	    System.out.println("id = "+ member.getId());

	    List<Product> products = productRepository.findByWriter(member.getId()); // writer 컬럼 값이 id와 일치하는 상품 리스트를 가져옵니다.
	    model.addAttribute("products", products);
	    return "product/getproductinfo"; // id별 상품리스트로 이동
	}
	
	
	//상품수정 코드 본인작성
//	@PostMapping("/updateproduct")
//	public String updateproduct(Model model) {
//		List<Product> products = productRepository.findAll();
//		model.addAllAttributes(products);
//		return "product/updateproduct";
//		
//	}
	
	
	@GetMapping("/product/updateproduct")
	public String updateproductForm(Product product) {
		return "/product/updateproduct";
		
	}
	// gpt작성
	@PostMapping("/product/updateproduct")
	public String updateProduct(@ModelAttribute("member") Member member, Product product) {
		if(member.getId() != product.getWriter()) {
			return "redirect:login";
		}
		productService.updateProduct(product);
		return "redirect:/product/updateproduct";
	    } 
	    
	   
	
	
}
