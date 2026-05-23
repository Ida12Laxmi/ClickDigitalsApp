package com.example.Spring.Boot.repository;

import com.example.Spring.Boot.model.Schedule;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long>{
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO schedule(cn,industry,email,proposal) VALUES (:cn, :industry, :email, :proposal)", nativeQuery = true)
    int registerSchedule(@Param("cn") String cn, @Param("industry") String industry, @Param("email") String email, @Param("proposal") String proposal);
}
