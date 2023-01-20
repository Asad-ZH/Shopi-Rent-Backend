package com.example.application.Entity;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Table(appliesTo = "favourites")
public class Favourites {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Long productId;
    private Long buyerId;
}
