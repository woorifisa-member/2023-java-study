package com.woorifisa.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Returns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_id",nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Date time;
    private int odometer;
    @Column(name = "full_tank")
    private int fullTank;
    private String city;
    @Column(name = "phone_number")
    private String phoneNumber;


}
