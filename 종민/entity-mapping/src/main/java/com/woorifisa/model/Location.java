package com.woorifisa.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_ID")
    private int locationId;

    @Column(name = "CITY")
    private String city;

    @OneToMany(mappedBy = "location")
    private List<CarLocation> carLocations = new ArrayList<>();

    @OneToMany(mappedBy = "locationId")
    private List<Return> returns = new ArrayList<>();

    @OneToMany(mappedBy = "locationId")
    private List<Reserve> reserves = new ArrayList<>();
}
