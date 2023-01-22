package com.example.application.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "payment")
public class Payment {
    @Id
    private Long id;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "checkout_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "checkout_id_fk"
            )
    )
    private Checkout checkout;

    private String paymentType;
    private Integer phoneNumber;
    private Integer productPrice;

}
