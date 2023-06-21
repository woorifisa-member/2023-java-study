package com.woorifisa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Return> carLocation = new ArrayList<Return>();

    @OneToMany(mappedBy = "customer")
    private List<Reserve> reserve = new ArrayList<Reserve>();

    public Customer(String name, String address) {
        super();
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer [customer_id=" + customerId + ", name=" + name + ", address=" + address + "]";
    }

}
