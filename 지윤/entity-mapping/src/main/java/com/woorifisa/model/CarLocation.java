package com.woorifisa.model;

import javax.persistence.*;

@Entity
public class CarLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="car_location_id",nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;
    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;
}
