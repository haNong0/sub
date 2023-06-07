package com.lec.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.domain.Member;
import com.lec.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
