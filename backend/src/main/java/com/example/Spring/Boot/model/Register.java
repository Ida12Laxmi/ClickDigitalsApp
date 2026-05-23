package com.example.Spring.Boot.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    public Long rid;
    public String name;
    public String email;
    public String phone;
    public String address;
    public String password;
    public Date registration_date;

    public Register(){

    }

    public Long getRid(){
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
}
