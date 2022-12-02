package com.example.java8.fetures.consumer;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        ConsumerDemo consumerDemo = new ConsumerDemo();
        consumerDemo.squareInt(5);

        Consumer<Integer> squareMe = integer -> System.out.println("taking a input " + integer + " and performing operation");
        squareMe.accept(5);

    }

    private void squareInt(int i) {
        int squared = i * i;
        System.out.println("squared of " + i + " is "  + squared);
    }
}
