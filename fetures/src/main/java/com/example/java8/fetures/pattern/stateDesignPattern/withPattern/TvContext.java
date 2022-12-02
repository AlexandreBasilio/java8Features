package com.example.java8.fetures.pattern.stateDesignPattern.withPattern;

/*
Notice that Context also implements State and keep a reference of its current state and forwards the request to the state implementation.
 */
public class TvContext implements State {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void doAction() {
       state.doAction();
    }
}
