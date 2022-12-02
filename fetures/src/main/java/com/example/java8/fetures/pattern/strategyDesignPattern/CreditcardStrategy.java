package com.example.java8.fetures.pattern.strategyDesignPattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreditcardStrategy implements PaymentStrategy {

    private String name;
    private String cardNumber;
    private String cvv;
    private String dataOfExpiry;

    @Override
    public void pay(int ammout) {
        System.out.println("Credicard payment " + ammout);
    }
}
