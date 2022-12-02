package com.example.java8.fetures.lambda.ex1;

public class Main {

    private static String name = "alex";

    public static void main (String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Rodando");
            }};

        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("My Runnable");
            }};

        Runnable r2 = () -> {
            int x =0;
            x++;
            System.out.println("Rodando with lambda. valor x=" + x + " name=" + name);
        };

        Runnable r3 = () -> System.out.println("Lambda expression exactely one statement");

        runnable.run();
        r.run();
        r2.run();
        r3.run();
    }
}
