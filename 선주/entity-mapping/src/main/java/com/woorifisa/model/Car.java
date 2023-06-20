package com.woorifisa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;

    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "car")
    private List<CarLocation> carLocation = new ArrayList<CarLocation>();

    public Car(String type) {
        super();
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car [carId=" + carId + ", type=" + type + "]";
    }

}
