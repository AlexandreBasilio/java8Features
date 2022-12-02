package com.example.java8.fetures.threadExamples;

public class TestTestM {

    public static void main(String[] args) {
        TestM t = new TestM(5000);
        Thread th = new Thread(t);
        th.start();
    }

}
