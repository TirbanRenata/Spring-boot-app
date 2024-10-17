package com.itschool.spring_boot_app.Services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreeting(String name) {

        return "Hello, " + name;

    }
}
