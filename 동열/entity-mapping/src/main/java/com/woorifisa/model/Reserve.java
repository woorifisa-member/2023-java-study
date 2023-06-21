package com.woorifisa.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reserves")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_id")
    private Long id;

    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;

    @Column(name = "pickup_date", nullable = false)
    private LocalDate pickupDate;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Builder
    public Reserve(String vehicleType, LocalDate pickupDate, LocalDate returnDate, String phoneNumber,
                   Location location, Customer customer) {
        this.vehicleType = vehicleType;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.customer = customer;
    }

}
