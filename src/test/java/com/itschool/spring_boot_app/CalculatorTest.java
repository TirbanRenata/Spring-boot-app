package com.itschool.spring_boot_app;
import com.itschool.spring_boot_app.SoftwareQualityAndUnitTesting.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {

    private final Calculator calculator = new Calculator();


    @Test
    public void testAdd() {
        double result = calculator.add(3, 2);
        assertEquals(5, result, "The addition result should be 5");
    }


    @Test
    public void testAddNegative() {
        double result = calculator.add(-3, 2);
        assertEquals(-1, result, "The addition result should be -1");
    }


    @Test
    public void testSubtract() {
        double result = calculator.subtract(5, 2);
        assertEquals(3, result, "The subtraction result should be 3");
    }


    @Test
    public void testSubtractNegative() {
        double result = calculator.subtract(2, 5);
        assertEquals(-3, result, "The subtraction result should be -3");
    }


    @Test
    public void testMultiply() {
        double result = calculator.multiply(3, 4);
        assertEquals(12, result, "The multiplication result should be 12");
    }


    @Test
    public void testMultiplyNegative() {
        double result = calculator.multiply(-3, 4);
        assertEquals(-12, result, "The multiplication result should be -12");
    }


    @Test
    public void testDivide() {
        double result = calculator.divide(6, 3);
        assertEquals(2, result, "The division result should be 2");
    }


    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(6, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage(), "Expected exception message to be 'Cannot divide by zero'");
    }


    @Test
    public void testDivideNegative() {
        double result = calculator.divide(6, -3);
        assertEquals(-2, result, "The division result should be -2");
    }
}
