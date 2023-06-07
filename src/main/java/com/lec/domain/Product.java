package com.lec.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Product {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 = 상품 코드
	 private Long pdid;
	
	
	 private String name;
	 private int price;
	 private int quantity;
}
