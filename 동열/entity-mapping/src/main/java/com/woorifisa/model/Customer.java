package com.woorifisa.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Return> returns = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Reserve> reserves = new ArrayList<>();

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
