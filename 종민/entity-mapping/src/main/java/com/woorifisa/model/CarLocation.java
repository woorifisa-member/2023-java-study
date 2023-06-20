package com.woorifisa.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarLocation implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "LOCATION_ID",nullable = false)
    private Location location;

    @Id
    @ManyToOne
    @JoinColumn(name = "CAR_ID",nullable = false)
    private Car car;


}
