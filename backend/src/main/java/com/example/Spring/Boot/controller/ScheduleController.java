package com.example.Spring.Boot.controller;

import com.example.Spring.Boot.model.Schedule;
import com.example.Spring.Boot.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    @Autowired

    private ScheduleRepository scheduleRepository;

    @PostMapping("/schedule")
    public ResponseEntity<Response> submitService(@RequestBody Schedule schedule){
        if(schedule.getCompanyName() == null || schedule.getCompanyName().trim().isEmpty() || schedule.getIndustry() == null || schedule.getIndustry().trim().isEmpty() ||schedule.getEmail() == null || schedule.getEmail().trim().isEmpty() || schedule.getProposal() == null || schedule.getProposal().trim().isEmpty()){
            return new ResponseEntity<>(
                    new Response(false, "Validation Failed", "Company Name, Industry, Email and Proposal are required fields."),
                    HttpStatus.BAD_REQUEST
            );

        }
        try{
            int rowsAffected=scheduleRepository.registerSchedule(
                    schedule.getCompanyName(),
                    schedule.getIndustry(),
                    schedule.getEmail(),
                    schedule.getProposal()
            );

            if (rowsAffected > 0) {
                return new ResponseEntity<>(
                        new Response(true, "Success", "Contact request submitted successfully!"),
                        HttpStatus.CREATED
                );
            } else {
                return new ResponseEntity<>(
                        new Response(false, "Failed", "Could not save contact message. Try again."),
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    new Response(false, "Error", "An unexpected database error occurred: " + e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

}
