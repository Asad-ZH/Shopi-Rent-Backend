package com.example.application.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "product")
@Data
public class Product {

    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "product_sequence"
    )
    @Id
    private Long id;

    @ManyToMany(mappedBy = "buyer_products")
    private List<Buyer> buyers = new ArrayList<>();

    @ManyToMany(mappedBy = "seller_products")
    private List<Seller> sellers = new ArrayList<>();

    @OneToOne(
            mappedBy = "product",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private Review review;

    @OneToOne(
            mappedBy = "product",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private OrderDetails orderDetails;

    @ManyToOne
    @JoinColumn(
            name = "favourites_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "product_favourites_fk"
            )
    )
    private Favourites favourites;

    @ManyToOne
    @JoinColumn(
            name = "cart_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "product_cart_fk"
            )
    )
    private Cart cart;

    private String title;
    private String description;
    private String imageURL;
    private String category;
    private String subCategory;
    private String weather;
    private String sleeves;
    private String brand;
    private String bodyType;
    private Integer securityDeposit;
    private Integer rentPerDay;
    private LocalDateTime pickUpDate;
    private LocalDateTime returnDate;
    private double rentingPrice;
    private double sellingPrice;
    private double saleRentingPrice;
    private double saleSellingPrice;

    @ElementCollection
    @CollectionTable(name = "Product_colors", joinColumns = @JoinColumn(name = "Product_colors_id"))
    @Column(name = "colors")
    private List<String> colors;

    @ElementCollection
    @CollectionTable(name = "Product_size", joinColumns = @JoinColumn(name = "Product_size_id"))
    @Column(name = "size")
    private List<String> size;

    @ElementCollection
    @CollectionTable(name = "Product_highlights", joinColumns = @JoinColumn(name = "Product_highlights_id"))
    @Column(name = "highlights")
    private List<String> highlights;

    public Product(String title, String description, String imageURL, String category, String subCategory, List<String> colors, List<String> size, String brand, List<String> highlights, String weather, String sleeves, String bodyType, Integer securityDeposit, Integer rentPerDay, LocalDateTime pickUpDate, LocalDateTime returnDate, double rentingPrice, double sellingPrice, double saleRentingPrice, double saleSellingPrice) {
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
        this.category = category;
        this.subCategory = subCategory;
        this.colors = colors;
        this.size = size;
        this.brand = brand;
        this.highlights = highlights;
        this.weather = weather;
        this.sleeves = sleeves;
        this.bodyType = bodyType;
        this.securityDeposit = securityDeposit;
        this.rentPerDay = rentPerDay;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.rentingPrice = rentingPrice;
        this.sellingPrice = sellingPrice;
        this.saleRentingPrice = saleRentingPrice;
        this.saleSellingPrice = saleSellingPrice;
    }

    public Product() {

    }
}
