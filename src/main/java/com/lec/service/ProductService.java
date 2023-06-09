package com.lec.service;

import java.util.List;


import com.lec.domain.Product;

public interface ProductService {
	
	Product getproduct(Product product);
	void insertproduct(Product product);
//	List<Product> getProductList(Product product);			// 전체 상품리스트조회
	List<Product> getProductListByAuthor(String sessionId); // 세션에 등록된 아이디로 상품리스트로조휘
	
	
}
