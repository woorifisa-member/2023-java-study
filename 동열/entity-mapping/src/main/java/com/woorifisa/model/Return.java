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
@Table(name = "returns")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_id")
    private Long id;

    @Column(nullable = false)
    private LocalDate time;

    @Column(nullable = false)
    private String odometer;

    @Column(name = "full_tank", nullable = false)
    private Integer fullTank;

    @Column(nullable = false)
    private String city;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Builder
    public Return(LocalDate time, String odometer, Integer fullTank, String city, String phoneNumber,
                  Location location, Customer customer) {
        this.time = time;
        this.odometer = odometer;
        this.fullTank = fullTank;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.customer = customer;
    }

}
