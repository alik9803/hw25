package com.example.calculator2;

import com.example.calculator2.service.CalculatorService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest2 {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testAdd() {
        int result = calculatorService.add(5, 5);
        assertEquals(10, result);
    }

    @Test
    public void testSubtract() {
        int result = calculatorService.subtract(5, 5);
        assertEquals(0, result);
    }

    @Test
    public void testMultiply() {
        int result = calculatorService.multiply(5, 5);
        assertEquals(25, result);
    }

    @Test
    public void testDivide() {
        int result = calculatorService.divide(5, 5);
        assertEquals(1, result);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(5, 0));
    }
}