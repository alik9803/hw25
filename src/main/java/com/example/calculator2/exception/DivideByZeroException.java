package com.example.calculator2.exception;


public class DivideByZeroException extends IllegalArgumentException {
    public DivideByZeroException(String message) {
        super(message);
    }
}