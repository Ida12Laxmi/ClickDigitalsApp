package com.example.Spring.Boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Spring.Boot.model.Contact;
import com.example.Spring.Boot.repository.ContactRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Transactional
    public int registerContactService(String name, String email, String phone, String subject, String message) {
        // Your repository method returns an int (number of rows affected)
        return contactRepository.registerContact(name, email, phone, subject,message);
    }


}
