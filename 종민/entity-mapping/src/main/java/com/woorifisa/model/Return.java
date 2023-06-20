package com.woorifisa.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.Date;

@Entity
@Table(name = "returns")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RETURN_ID")
    private int returnId;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID",nullable = false)
    private Location locationId;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID",nullable = false)
    private Location customerId;

    @Column(name = "TIME")
    private Date time;

    @Column(name = "ODOMETER")
    private int odoMeter;

    @Column(name = "FULL_TANK")
    private int fullTank;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

}
