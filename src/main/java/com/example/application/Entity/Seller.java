package com.example.application.Entity;

import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "seller")
@Data
public class Seller {

    @Id
    @SequenceGenerator(
            name = "seller_sequence",
            sequenceName = "seller_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "seller_sequence"
    )
    private Long id;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "seller_purchase",
            joinColumns = @JoinColumn(
                    name = "seller_id",
                    foreignKey = @ForeignKey(name = "purchase_seller_id_fk")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "seller_product_id",
                    foreignKey = @ForeignKey(name = "purchase_seller_product_id_fk")
            )
    )
    private List<Product> seller_products = new ArrayList<>();


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
