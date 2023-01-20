package com.example.application.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seller")
@Data
public class Seller {

    @Id
    private Long id;
    private String name;
    private String storeName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String province;
    private String country;
    private String zipCode;

}
