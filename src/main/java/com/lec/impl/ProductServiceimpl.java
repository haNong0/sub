package com.lec.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.domain.Product;
import com.lec.persistance.ProductRepository;
import com.lec.service.ProductService;
@Service
public class ProductServiceimpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	//상품등록
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
	@Override
	public List<Product> getProductList(Product product) {
		return null;
	}
	
	// id별상품리스트조회
	@Override
    public List<Product> getProductListByWriter(String writer) {
        return productRepository.findByWriter(writer);
    }

	//상품수정
//	@Override
	public void updateProduct(Product product) {
		Product findProduct = productRepository.findById(product.getWriter()).get();
		findProduct.setPrice(product.getPrice());
		findProduct.setQuantity(product.getQuantity());
		productRepository.save(product);
	}

	
		
	
}
