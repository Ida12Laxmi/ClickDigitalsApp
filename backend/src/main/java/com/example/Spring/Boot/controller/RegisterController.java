package com.example.Spring.Boot.controller;
import com.example.Spring.Boot.model.Register;
import com.example.Spring.Boot.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    //private RegisterRepository registerRepository;
    private RegisterService registerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Response>submitUser(@RequestBody Register register){
        if(register.getName()==null || register.getName().trim().isEmpty() || register.getEmail()==null || register.getEmail().trim().isEmpty() || register.getPhone() ==null || register.getPhone().trim().isEmpty() || register.getAddress() ==null || register.getAddress().trim().isEmpty() || register.getPassword() ==null || register.getPassword().trim().isEmpty()){
            return new ResponseEntity<>(
                    new Response(false, "Validation Failed", "All fields are required fields."),
                    HttpStatus.BAD_REQUEST
            );
        }
        try{
            int rows_affected= registerService.registerUserService(register.getName(), register.getEmail(), register.getPhone(), register.getAddress(),register.getPassword());
            if (rows_affected > 0) {
                return new ResponseEntity<>(
                        new Response(true, "Success", "User Registered"),
                        HttpStatus.CREATED
                );
            } else {
                return new ResponseEntity<>(
                        new Response(false, "Failed", "Could not process register. Please try again."),
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    new Response(false, "Error", "A database error occurred: " + e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Response> loginUserResponse(@RequestBody Register login){
        String email= login.getEmail();
        String password= login.getPassword();

        if(email==null || email.trim().isEmpty() || password ==null || password.trim().isEmpty()){
            return new ResponseEntity<>(
                    new Response(false, "Email and password are required.", "login"),
                    HttpStatus.BAD_REQUEST
            );
        }
        try{
            Optional<Register> userOptional=registerService.findUserByEmail(email);
            if(userOptional.isEmpty()){
                return new ResponseEntity<>(
                        new Response(false, "Incorrect email or password.", "register"),
                        HttpStatus.UNAUTHORIZED
                );
            }
            Register user=userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return new ResponseEntity<>(
                        new Response(true, "Login successful!", "hospital"),
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        new Response(false, "Incorrect email or password.", "login"),
                        HttpStatus.UNAUTHORIZED
                );
            }

        } catch (Exception e) {
            //throw new RuntimeException(e);
            return new ResponseEntity<>(
                    new Response(false, "An error occurred during authentication.", "error"),
                    HttpStatus.INTERNAL_SERVER_ERROR // 500 Internal Server Error
            );
        }
    }
}
