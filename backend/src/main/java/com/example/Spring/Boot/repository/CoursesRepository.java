package com.example.Spring.Boot.repository;
import com.example.Spring.Boot.model.Courses;
import com.example.Spring.Boot.model.Enrollment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CoursesRepository extends CrudRepository<Courses,Long>{
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO courses(fullname,email,phone,service_selected,budget_range) VALUES (:fullname,:email,:phone,:service_selected,:budget_range)", nativeQuery = true)
    int registerCourses(@Param("fullname") String fullname, @Param("email") String email, @Param("phone") String phone, @Param("service_selected") String service_selected, @Param("budget_range") String budget_range);


}
