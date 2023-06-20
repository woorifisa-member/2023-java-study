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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "city", nullable = false)
    private String city;

    @OneToMany(mappedBy = "location")
    private List<CarLocation> carLocation = new ArrayList<CarLocation>();

    @OneToMany(mappedBy = "location")
    private List<Reserve> reserve = new ArrayList<Reserve>();

    @OneToMany(mappedBy = "location")
    private List<Return> returns = new ArrayList<Return>();

    public Location(String city) {
        super();
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location [locationId=" + locationId + ", city=" + city + "]";
    }

}
