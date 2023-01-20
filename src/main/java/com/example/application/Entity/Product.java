package com.example.application.Entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    private Long id;
//    private Long sellerId;
    private String title;
    private String description;
    private String imageURL;
    private String category;
    private String subCategory;

    @ElementCollection
    @CollectionTable(name = "Product_colors", joinColumns = @JoinColumn(name = "Product_colors_id"))
    @Column(name = "colors")
    private List<String> colors;

    @ElementCollection
    @CollectionTable(name = "Product_size", joinColumns = @JoinColumn(name = "Product_size_id"))
    @Column(name = "size")
    private List<String> size;
    private String brand;

    @ElementCollection
    @CollectionTable(name = "Product_highlights", joinColumns = @JoinColumn(name = "Product_highlights_id"))
    @Column(name = "highlights")
    private List<String> highlights;
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
