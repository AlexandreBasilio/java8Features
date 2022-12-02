package com.example.java8.fetures.pattern.stateDesignPattern.withPattern;

/*
The benefits of using State pattern to implement polymorphic behavior is clearly visible.
 The chances of error are less and it’s very easy to add more states for additional behavior.
  Thus making our code more robust, easily maintainable and flexible.

Also State pattern helped in avoiding if-else or switch-case conditional logic in this scenario.

 */
public class TvRemote {

    public static void main(String[] args) {
        TvContext tvContext = new TvContext();
        TvStartState tvStartState = new TvStartState();
        TvStopState tvStopState = new TvStopState();

        tvContext.setState(tvStartState);
        tvContext.doAction();

        tvContext.setState(tvStopState);
        tvContext.doAction();
    }
}
