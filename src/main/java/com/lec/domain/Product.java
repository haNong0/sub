package com.lec.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 상품 코드

    private String name;
    private int price;
    private int quantity;
    private String writer;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_role")
//    private Member member;
//
//    // 생성자, 게터, 세터, toString 등 생략
}