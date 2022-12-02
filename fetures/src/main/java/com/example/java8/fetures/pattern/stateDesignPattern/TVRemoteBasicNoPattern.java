package com.example.java8.fetures.pattern.stateDesignPattern;

public class TVRemoteBasicNoPattern {

    private String state="";

    public void setState(String state) {
        this.state = state;
    }

    public void doAction() {
        if(state.equalsIgnoreCase("ON")){
            System.out.println("TV is turned ON");
        }else if(state.equalsIgnoreCase("OFF")){
            System.out.println("TV is turned OFF");
        }
    }

    /*
    Notice that client code should know the specific values to use for setting the state of remote.
    Further more if number of states increase then the tight coupling between implementation and
    the client code will be very hard to maintain and extend.
     */
    public static void main(String args[]){
        TVRemoteBasicNoPattern remote = new TVRemoteBasicNoPattern();

        remote.setState("ON");  //should know the specific values to use for setting the state of remote.
        remote.doAction();

        remote.setState("OFF"); // should know the specific values to use for setting the state of remote.
        remote.doAction();
    }
}
