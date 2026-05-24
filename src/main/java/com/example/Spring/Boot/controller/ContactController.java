package com.example.Spring.Boot.controller;

import com.example.Spring.Boot.model.Contact;
import com.example.Spring.Boot.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contacts")
    public ResponseEntity<ContactResponse> submitContact(@RequestBody Contact contact) {
        // 1. Basic validation
        if (contact.getName() == null || contact.getName().trim().isEmpty() ||
                contact.getEmail() == null || contact.getEmail().trim().isEmpty() ||
                contact.getPhone() == null || contact.getPhone().trim().isEmpty() ||
                contact.getSubject() == null || contact.getSubject().trim().isEmpty() ||
                contact.getMessage() == null || contact.getMessage().trim().isEmpty()) {

            return new ResponseEntity<>(
                    new ContactResponse(false, "Validation Failed", "Name, Email, Phone, Subject and Message are required fields."),
                    HttpStatus.BAD_REQUEST
            );
        }

        try {
            // 2. Using your custom native SQL query from the repository
            int rowsAffected = contactRepository.registerContact(
                    contact.getName(),
                    contact.getEmail(),
                    contact.getPhone(),
                    contact.getSubject(),
                    contact.getMessage()
            );

            if (rowsAffected > 0) {
                return new ResponseEntity<>(
                        new ContactResponse(true, "Success", "Contact request submitted successfully!"),
                        HttpStatus.CREATED
                );
            } else {
                return new ResponseEntity<>(
                        new ContactResponse(false, "Failed", "Could not save contact message. Try again."),
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    new ContactResponse(false, "Error", "An unexpected database error occurred: " + e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}

class ContactResponse {
    private boolean success;
    private String status;
    private String message;

    public ContactResponse(boolean success, String status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }

    // Getters and Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}