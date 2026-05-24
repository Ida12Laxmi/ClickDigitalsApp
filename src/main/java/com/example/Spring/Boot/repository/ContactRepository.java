package com.example.Spring.Boot.repository;
import com.example.Spring.Boot.model.Contact;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO contact(name,email,phone,subject,message) VALUES (:name, :email, :phone, :subject, :message)", nativeQuery = true)
    int registerContact(@Param("name") String name, @Param("email") String email, @Param("phone") String phone, @Param("subject") String subject, @Param("message") String message);

}
