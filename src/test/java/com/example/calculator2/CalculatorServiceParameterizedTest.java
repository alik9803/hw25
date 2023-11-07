package com.example.calculator2;

import com.example.calculator2.service.CalculatorService;
import com.example.calculator2.exception.DivideByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class CalculatorServiceParameterizedTest {
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        calculatorService = new CalculatorService();
    }

    static Stream<Arguments> argsForSum() {
        return Stream.of(
                Arguments.of(5, 2, 7),
                Arguments.of(10, 4, 14),
                Arguments.of(7, 3, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForSum")
    void testSum(int num1, int num2, int expectedResult) {
        int sum = calculatorService.sum(num1, num2);
        assertEquals(expectedResult, sum);
    }

    @ParameterizedTest
    @CsvSource({"5, 2, 3", "10, 10, 0", "1234, 234, 1000"})
    void testSubtraction(int num1, int num2, int expectedResult) {
        int sub = calculatorService.subtraction(num1, num2);
        assertEquals(expectedResult, sub);
    }

    static Stream<Arguments> argsForMultiply() {
        return Stream.of(
                Arguments.of(3, 3, 9),
                Arguments.of(4, 5, 20),
                Arguments.of(10, 10, 100)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForMultiply")
    void testMultiply(int num1, int num2, int expectedResult) {
        int multiply = calculatorService.multiply(num1, num2);
        assertEquals(expectedResult, multiply);
    }

    @ParameterizedTest
    @CsvSource({"100, 10, 10", "1000, 100, 10", "9, 3, 3"})
    void testDivide(int num1, int num2, int expectedResult) {
        int divide = calculatorService.divide(num1, num2);
        assertEquals(expectedResult, divide);
    }

    @ParameterizedTest
    @CsvSource({"7, 0"})
    void testDivideByZeroException(int num1, int num2) {
        Assertions.assertThrows(DivideByZeroException.class, () -> calculatorService.divide(num1, num2));
    }
}