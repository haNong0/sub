package com.lec.service;

import java.util.List;


import com.lec.domain.Product;

public interface ProductService {
	
	Product getproduct(Product product);						//
	void insertproduct(Product product);						//	상품 등록	
	List<Product> getProductList(Product product);				 // 전체 상품리스트조회
    public List<Product> getProductListByWriter(String writer); // 	id별 상품리스트조회
    void updateProduct(Product product);						//	상품 수정
	
	
}
