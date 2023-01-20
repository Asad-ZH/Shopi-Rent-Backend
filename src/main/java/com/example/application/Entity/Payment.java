package com.example.application.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "payment")
public class Payment {
    @Id
    private Long id;

    private String paymentType;
//    private Long orderId;
    private Integer phoneNumber;
    private Integer productPrice;

}
