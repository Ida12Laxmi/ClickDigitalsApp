package com.example.Spring.Boot.controller;

import com.example.Spring.Boot.model.Enrollment;
import com.example.Spring.Boot.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EnrollmentController {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @PostMapping("/enrollment")
    public ResponseEntity<Response>submitEnrollment(@RequestBody Enrollment enrollment){
        if(enrollment.getFullname() == null || enrollment.getFullname().trim().isEmpty() || enrollment.getEmail() == null || enrollment.getEmail().trim().isEmpty() || enrollment.getPhone() == null || enrollment.getPhone().trim().isEmpty() || enrollment.getCompany() == null || enrollment.getCompany().trim().isEmpty() || enrollment.getService() == null || enrollment.getService().trim().isEmpty() || enrollment.getBudget_range()==null || enrollment.getBudget_range().trim().isEmpty()){
            return new ResponseEntity<>(
                    new Response(false, "Validation Failed", "All fields are required fields."),
                    HttpStatus.BAD_REQUEST
            );
        }
        try{
            int rows_affected= enrollmentRepository.registerEnrollment(enrollment.getFullname(), enrollment.getEmail(), enrollment.getPhone(), enrollment.getCompany(),enrollment.getService(), enrollment.getBudget_range());
            if (rows_affected > 0) {
                return new ResponseEntity<>(
                        new Response(true, "Success", "Enrolled in course successfully!"),
                        HttpStatus.CREATED
                );
            } else {
                return new ResponseEntity<>(
                        new Response(false, "Failed", "Could not process enrollment. Please try again."),
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    new Response(false, "Error", "A database error occurred: " + e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
