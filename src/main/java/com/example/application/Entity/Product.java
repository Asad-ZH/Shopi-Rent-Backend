package com.example.application.Entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    private Long id;
    private Long sellerId;
    private String title;
    private String description;
    private String imageURL;
    private String category;
    private String subCategory;
    @Column(name = "colors", columnDefinition = "text[]")
    @Type(type = "text[]")
    private String[] colors;
    @Column(name = "size", columnDefinition = "text[]")
    @Type(type = "text[]")
    private String[] size;
    private String brand;
    @Column(name = "highlights", columnDefinition = "text[]")
    @Type(type = "text[]")
    private String[] highlights;
    private String weather;
    private String sleeves;
    private String bodyType;
    private Long securityDeposit;
    private Long rentPerDay;
    private LocalDateTime pickUpDate;
    private LocalDateTime returnDate;
    private double rentingPrice;
    private double sellingPrice;
    private double saleRentingPrice;
    private double saleSellingPrice;
}
