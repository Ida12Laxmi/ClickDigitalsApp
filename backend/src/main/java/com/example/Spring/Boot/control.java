package com.example.Spring.Boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class control {
    @RequestMapping("/hello")
    public String hello()
    {
        return "Hello";
    }
}
