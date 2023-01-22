package com.example.application.Entity;

import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @SequenceGenerator(
            name = "buyer_sequence",
            sequenceName = "buyer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "buyer_sequence"
    )
    private Long id;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "buyer_purchase",
            joinColumns = @JoinColumn(
                    name = "buyer_id",
                    foreignKey = @ForeignKey(name = "purchase_buyer_id_fk")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "buyer_product_id",
                    foreignKey = @ForeignKey(name = "purchase_buyer_product_id_fk")
            )
    )
    private List<Product> buyer_products = new ArrayList<>();

    @OneToOne(
            mappedBy = "buyer",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private Review review;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer phone;

    public Buyer() {
    }

    public Buyer(String firstName, String lastName, String email, String password, Integer phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }


}
