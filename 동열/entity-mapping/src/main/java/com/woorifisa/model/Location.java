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
@Table(name = "locations")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "location")
    private List<CarLocation> carLocations = new ArrayList<>();

    @OneToMany(mappedBy = "location")
    private List<Reserve> reserves = new ArrayList<>();

    @OneToMany(mappedBy = "location")
    private List<Return> returns = new ArrayList<>();

    public Location(String city) {
        this.city = city;
    }

}
