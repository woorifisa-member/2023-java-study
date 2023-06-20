package com.woorifisa.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int id;

    @Column
    private String name;

    @Column
    private String address;

    @OneToMany(mappedBy = "customerId")
    List<Return> returns = new ArrayList<>();

    @OneToMany(mappedBy = "customerId")
    List<Reserve> reserves = new ArrayList<>();
}
