package com.example.Spring.Boot.controller;

import com.example.Spring.Boot.model.Courses;
import com.example.Spring.Boot.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CoursesController {
    @Autowired
    private CoursesRepository coursesRepository;


    @PostMapping("/courses")
    public ResponseEntity<Response> submitCourses(@RequestBody Courses courses){
        if(courses.getFullname() == null || courses.getFullname().trim().isEmpty() || courses.getEmail() == null || courses.getEmail().trim().isEmpty() || courses.getPhone() == null || courses.getPhone().trim().isEmpty() || courses.getService_selected() == null || courses.getService_selected().trim().isEmpty() || courses.getBudget_range()==null || courses.getBudget_range().trim().isEmpty()){
            return new ResponseEntity<>(
                    new Response(false, "Validation Failed", "All fields are required fields."),
                    HttpStatus.BAD_REQUEST
            );
        }
        try{
            int rows_affected= coursesRepository.registerCourses(courses.getFullname(), courses.getEmail(), courses.getPhone(), courses.getService_selected(), courses.getBudget_range());
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
