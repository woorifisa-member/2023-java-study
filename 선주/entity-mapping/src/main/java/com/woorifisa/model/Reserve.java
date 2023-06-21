package com.woorifisa.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 아무것도 인자 없는 생성자 - 상속 관계만 접근가능 - 인자가 비어져있는 거는 세터를 이용할 확률이 높아서 위험
public class Reserve {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="reserve_id")
    private Long reserveId;

    @Column(name="vehicle_type", nullable=false)
    private String vehicleType;

    @Column(name="picku_date", nullable=false)
    private Date pickupDate;

    @Column(name="return_date", nullable=false)
    private Date returnDate;

    @Column(name="phone_number", nullable=false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="locaton_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;


    public Reserve(String vehicleType, Date pickupDate, Date returnDate, String phoneNumber, Location location,
                   Customer costomer) {
        super();
        this.vehicleType = vehicleType;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.customer = costomer;
    }

    @Override
    public String toString() {
        return "Reserve [reserveId=" + reserveId + ", vehicleType=" + vehicleType + ", pickupDate=" + pickupDate
                + ", returnDate=" + returnDate + ", phoneNumber=" + phoneNumber + ", location=" + location
                + ", costomer=" + customer + "]";
    }






}
