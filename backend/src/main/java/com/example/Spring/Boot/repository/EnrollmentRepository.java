package com.example.Spring.Boot.repository;
import com.example.Spring.Boot.model.Enrollment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EnrollmentRepository extends CrudRepository<Enrollment,Long>{
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO enrollment(fullname,email,phone,company,service,budget_range) VALUES (:fullname,:email,:phone,:company,:service,:budget_range)", nativeQuery = true)
    int registerEnrollment(@Param("fullname") String fullname, @Param("email") String email, @Param("phone") String phone, @Param("company") String company, @Param("service") String service, @Param("budget_range") String budget_range);

}
