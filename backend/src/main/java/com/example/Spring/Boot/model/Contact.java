package com.example.Spring.Boot.model;
import jakarta.persistence.*;

import java.util.*;
@Entity
@Table(name="contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coid")

    public Long coid;
    public String name;
    public String email;
    public String phone;
    public String subject;
    public String message;

    public Long getCoid(){
        return coid;
    }

    public void setCoid(Long coid) {
        this.coid = coid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
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

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
