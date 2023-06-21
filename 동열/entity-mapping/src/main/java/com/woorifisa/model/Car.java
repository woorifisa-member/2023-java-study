package com.woorifisa.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "car")
    private List<CarLocation> carLocations = new ArrayList<>();

    public Car(String type) {
        this.type = type;
    }

}
