package com.example.Spring.Boot.service;

import com.example.Spring.Boot.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleService {
 @Autowired
    private ScheduleRepository scheduleRepository;
    @Transactional
    public int registerScheduleService(String cn, String industry, String email, String proposal){
        return scheduleRepository.registerSchedule(cn, industry, email, proposal);
    }
}
