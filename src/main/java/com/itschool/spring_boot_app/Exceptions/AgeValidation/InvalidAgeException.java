package com.itschool.spring_boot_app.Exceptions.AgeValidation;

public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
