package com.example.Spring.Boot.service;

import com.example.Spring.Boot.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;
    @Transactional
    public int registerCoursesService(String fullname, String email, String phone, String service_selected, String budget_range){
        return coursesRepository.registerCourses(fullname, email, phone, service_selected, budget_range);
    }
}
