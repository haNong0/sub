package com.lec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.lec.domain.Member;
import com.lec.domain.Product;
import com.lec.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/addproduct")
	public String addproductForm (Product product) {
		return "product/addproduct";
		
	}
	
	
	@PostMapping("/addproduct")
	public String addproduct(@ModelAttribute("product") Product product, Member member) {

		if(product.getPdid() == null) {
			return "redirect:getproductinfo";
		}	
		
		productService.insertproduct(product);
		return "redirect:getproductinfo";
	}
	
	@GetMapping("/getproductinfo")
	public String getproductinfo (Product product) {
		return "product/getproductinfo";
		
	}
	
	
	
}
