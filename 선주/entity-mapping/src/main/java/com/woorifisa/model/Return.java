package com.woorifisa.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
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
    private Long returnId;

    @Column(name = "time", nullable = false)
    private Date time;

    @Column(name = "odometer", nullable = false)
    private int odometer;

    @Column(name = "full_tank", nullable = false)
    private int fullTank;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Return(Date time, int odometer, int fullTank, String city, String phoneNumber) {
        super();
        this.time = time;
        this.odometer = odometer;
        this.fullTank = fullTank;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Return [returnId=" + returnId + ", time=" + time + ", odometer=" + odometer + ", fullTank=" + fullTank
                + ", city=" + city + ", phoneNumber=" + phoneNumber + "]";
    }

}
