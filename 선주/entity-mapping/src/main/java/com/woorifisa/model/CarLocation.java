package com.woorifisa.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarLocation {

    @EmbeddedId
    private CarLocationId carLocationId;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @MapsId("carId")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @MapsId("locationId")
    private Location location;

    @NoArgsConstructor // 아무 인자 없는 생성자
    @EqualsAndHashCode // equals 랑 hashcode 메서드를 합쳐 놓은 건데, 동일성을 확인하려고 한다.
    @Embeddable
    public class CarLocationId implements Serializable {
        private Long carId;
        private Long locationId;
    }

}
