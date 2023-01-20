package com.example.application.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    private Long id;

    private Long buyerId;
    private Long productId;

    private String review;
    private Integer rating;
}
