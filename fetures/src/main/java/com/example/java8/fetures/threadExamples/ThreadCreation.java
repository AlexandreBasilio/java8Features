package com.example.java8.fetures.threadExamples;

public class ThreadCreation {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running thread inner class");
            }
        });
        t.start();

        Runnable runnable = () -> System.out.println("Runnable lambda");
        runnable.run();
    }


}
