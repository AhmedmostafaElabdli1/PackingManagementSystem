package com.backend.projectjpa.Entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Entity
@Table(name ="trader")
public class Trader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "trader_sequence", sequenceName = "trader_seq", allocationSize = 1, initialValue = 10000)
    private Long trader_id;
    @Column(nullable = false)
    private String trader_name;

    //    @Column(name = "address")
    private String address;

    //    @Column(name = "phone_number", length = 11)
    private String phone_number;

    //    @Column(name = "email")
    private String email;

    //    @Column(name = "registration_date")
    @Column(name = "registration_date")
    private Date registration_date;

    public Long getTrader_id() {
        return trader_id;
    }

    public void setTrader_id(Long trader_id) {
        this.trader_id = trader_id;
    }

    public String getTraderName() {
        return trader_name;
    }

    public void setTraderName(String traderName) {
        this.trader_name = traderName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registration_date;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registration_date = registrationDate;
    }

    // Constructors, getters, setters, and other methods

}
