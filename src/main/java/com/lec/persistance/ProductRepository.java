package com.lec.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.domain.Member;
import com.lec.domain.Product;

public interface ProductRepository extends JpaRepository<Product, String>{



	 List<Product> findByid(String id); //전체 상품리스트조회
	 List<Product> findByWriter(String writer); // id별 상품리스트조회
	Optional<Product> findById(Long seq);	//상품리스트 수정



	

	
	

	

}
