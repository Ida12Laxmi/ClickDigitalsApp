package com.example.Spring.Boot.model;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")

    public Long cid;
    public String fullname;
    public String email;
    public String phone;
    public String service_selected;
    public String budget_range;
    public Date created_at;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public String getService_selected(){
        return service_selected;
    }

    public void setService_selected(String service_selected) {
        this.service_selected = service_selected;
    }

    public String getBudget_range(){
        return budget_range;
    }

    public void setBudget_range(String budget_range) {
        this.budget_range = budget_range;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

}
