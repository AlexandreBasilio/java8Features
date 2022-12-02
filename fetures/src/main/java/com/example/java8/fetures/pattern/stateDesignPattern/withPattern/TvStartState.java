package com.example.java8.fetures.pattern.stateDesignPattern.withPattern;

public class TvStartState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is ON");
    }
}
