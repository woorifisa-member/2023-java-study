package com.woorifisa.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id",nullable = false)
    private long id;
    private String type;
}
