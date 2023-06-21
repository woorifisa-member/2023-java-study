package com.woorifisa.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car_location")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CarLocation {

    @EmbeddedId
    private Id id;

    @MapsId(value = "carId")
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @MapsId(value = "locationId")
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Embeddable
    @EqualsAndHashCode
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Id implements Serializable {
        private Long carId;
        private Long locationId;
    }

    public CarLocation(Car car, Location location) {
        this.car = car;
        this.location = location;
        this.id = new Id(car.getId(), location.getId());
    }

}
