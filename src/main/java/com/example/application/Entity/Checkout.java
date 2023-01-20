package com.example.application.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "checkout")
public class Checkout {

    @Id
    private Long id;
//    private Long orderId;
    private String firstName;
    private String lastName;
    private String country;
    private String province;
    private String city;
    private String address;
    private String zipCode;
    private Integer phoneNumber;


}
