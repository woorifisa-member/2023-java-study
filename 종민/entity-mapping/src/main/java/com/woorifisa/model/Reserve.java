package com.woorifisa.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVE_ID")
    private int reserveId;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", nullable = false)
    private Location locationId;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customerId;

    @Column(name = "VEHICLE_TYPE")
    private String vehicleType;

    @Column(name = "PICKUP_DATE")
    private Date pickupDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;







}
