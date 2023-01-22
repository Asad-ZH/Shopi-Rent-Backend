package com.example.application.Entity;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "checkout")
public class Checkout {

    @Id
    @SequenceGenerator(
            name = "checkout_sequence",
            sequenceName = "checkout_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "checkout_sequence"
    )
    private Long id;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "orderDetails_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "orderDetails_id_fk"
            )
    )
    private OrderDetails orderDetails;

    @OneToOne(
            mappedBy = "checkout",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private Payment payment;

    private String firstName;
    private String lastName;
    private String country;
    private String province;
    private String city;
    private String address;
    private String zipCode;
    private Integer phoneNumber;


}
