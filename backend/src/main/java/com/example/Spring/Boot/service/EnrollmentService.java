package com.example.Spring.Boot.service;

import com.example.Spring.Boot.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Transactional
    public int registerEnrollmentRepository(String fullname, String email, String phone, String company, String service, String budget_range){
        return enrollmentRepository.registerEnrollment(fullname, email, phone, company, service, budget_range);
    }

}
