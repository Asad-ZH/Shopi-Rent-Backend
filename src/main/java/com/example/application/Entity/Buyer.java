package com.example.application.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "buyers")
public class Buyer {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;

}
