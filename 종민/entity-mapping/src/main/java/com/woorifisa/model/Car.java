package com.woorifisa.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID")
    private int id;

    @Column(name = "TYPE")
    private String type;

    @OneToMany(mappedBy = "car")
    private List<CarLocation> carLocations = new ArrayList<>();

}
