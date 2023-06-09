package com.lec.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/addproduct")
	public String addproductForm (Product product) {
		return "product/addproduct";
		
	}
	
	
	@PostMapping("/addproduct")
	public String addproduct(@ModelAttribute("product") Product product, Member member) {

		if(product.getId() == null) {
			return "redirect:getproductinfo";
		}
		
		productService.insertproduct(product);
		return "redirect:getproductinfo";
	}

	// 전체 상픔리스트를 조회하는 코드
//	@GetMapping("/getproductinfo")
//    public String productList(Model model) {
//        List<Product> products = productRepository.findAll();
//        model.addAttribute("products", products);
//        return "product/getproductinfo"; // productList.html 템플릿을 반환합니다.
//    }
	// 아이디별로 조회하는 코드 gpt작성
	@GetMapping("/getproductinfo")
	public String getProductListBySessionId(HttpSession session, Model model) {
	    String sessionId = (String) session.getAttribute("id");
	    List<Product> products = productService.getProductListByAuthor(sessionId);
	    model.addAttribute("products", products);
	    return "product/getproductinfo";
	}
	
}
