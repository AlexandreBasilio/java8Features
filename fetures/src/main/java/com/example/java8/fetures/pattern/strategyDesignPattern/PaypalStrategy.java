package com.example.java8.fetures.pattern.strategyDesignPattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaypalStrategy implements PaymentStrategy {

    private String email;
    private String password;

    @Override
    public void pay(int ammout) {
        System.out.println("Payment via PayPAL " + ammout);
    }
}
