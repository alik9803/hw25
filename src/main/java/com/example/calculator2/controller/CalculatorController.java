package com.example.calculator2.controller;

import com.example.calculator2.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@RequestMapping("/calculator")
public class CalculatorController {
    ServiceInterface serviceInterface;

    @GetMapping
    public String sayHello() {
        return "Welcome to calculator";
    }

    @GetMapping("/plus")
    public String makeSum(@RequestParam int num1, @RequestParam int num2) {
        return num1 + "+" + num2 + "=" + serviceInterface.sum(num1, num2);
    }

    @GetMapping("/minus")
    public String makeSubtraction(@RequestParam int num1, @RequestParam int num2) {
        return num1 + "-" + num2 + "=" + serviceInterface.subtraction(num1, num2);
    }

    @GetMapping("/multiply")
    public String makeMultiply(@RequestParam int num1, @RequestParam int num2) {
        return num1 + "*" + num2 + "=" + serviceInterface.multiply(num1, num2);

    }

    @GetMapping("/divide")
    public String makeDivide(@RequestParam int num1, @RequestParam int num2) {
        return num1 + "/" + num2 + "=" + serviceInterface.divide(num1, num2);
    }
}