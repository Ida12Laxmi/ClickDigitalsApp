package com.example.Spring.Boot.model;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    public Long eid;
    public String fullname;
    public String email;
    public String phone;
    public String company;
    public String service;
    public String budget_range;
    public Date created_at;

    //default constructor
    public Enrollment(){
    }

    public Long getEnid() {
        return eid;
    }

    public void setEnid(Long eid) {
        this.eid = eid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getService(){
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getBudget_range() {
        return budget_range;
    }

    public void setBudget_range(String budget_range) {
        this.budget_range = budget_range;
    }

    public Date getCreated_at(){
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
