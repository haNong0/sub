package com.lec.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.domain.Product;
import com.lec.persistance.ProductRepository;
import com.lec.service.ProductService;
@Service
public class ProductServiceimpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	public void insertproduct(Product product) {
		 productRepository.save(product);		
	}

	@Override
	public Product getproduct(Product product) {
		Optional<Product> findProduct = productRepository.findById(product.getId());
		if(findProduct.isPresent()) 
			return findProduct.get();
		else return null;
	}
// 상품리스트 전체조회
//	@Override
//	public List<Product> getProductList(Product product) {
//		// TODO Auto-generated method stub
//		return null;
//	}
// 세션 아이디별로 상품조회
	@Override
	public List<Product> getProductListByAuthor(String sessionId) {
	    return productRepository.findByAuthorId(sessionId);
	}
	
}
