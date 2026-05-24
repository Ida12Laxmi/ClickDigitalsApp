package com.example.Spring.Boot.repository;
import com.example.Spring.Boot.model.Register;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RegisterRepository extends CrudRepository<Register,Long>{
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO register(name,email,phone,address,password) VALUES (:name,:email,:phone,:address,:password)", nativeQuery = true)
    int registerUser(@Param("name") String name, @Param("email") String email, @Param("phone") String phone, @Param("address") String address, @Param("password") String password);

    @Query(value="SELECT * from register where email=:email",nativeQuery = true)
    Optional<Register> findByEmail(@Param("email") String email);

}
