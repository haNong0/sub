package com.lec.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.domain.Member;
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
		Optional<Product> findProduct = productRepository.findById(product.getPdid());
		if(findProduct.isPresent()) 
			return findProduct.get();
		else return null;
	}
}
