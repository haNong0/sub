package com.lec.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class Member {
    @Id
    private String id; // 회원 ID

    private String name;
    private String role;
    private String password;

//    @OneToMany(mappedBy = "member_id")
//    
//    private List<Product> products;
//    
    
}

