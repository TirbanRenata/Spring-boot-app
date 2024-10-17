package com.itschool.spring_boot_app.Exceptions.AgeValidation;

import java.util.Scanner;

public class AgeValidation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        scanner.close();

        try {
            validateAge(age);
            System.out.println("Age is valid");
        }catch (InvalidAgeException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void validateAge(int age) throws InvalidAgeException{

        if (age < 0 || age > 150){
            throw new InvalidAgeException("Age should be between 0 and 150.");
        }

    }

}
