package com.example.application.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
@Data
public class OrderDetails {

    @Id
    private Long id;

    private Long orderId;
    private Long productId;
    private Integer quantity;
    private double price;

}
