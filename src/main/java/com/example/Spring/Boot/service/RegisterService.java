package com.example.Spring.Boot.service;

import com.example.Spring.Boot.model.Register;
import com.example.Spring.Boot.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public int registerUserService(String name, String email, String phone, String address, String password){
        String hashedPassword=passwordEncoder.encode(password);
        return registerRepository.registerUser(name, email, phone, address, hashedPassword);
    }

    @Transactional(readOnly = true)
    public Optional<Register> findUserByEmail(String email){
        return registerRepository.findByEmail(email);
    }

}
