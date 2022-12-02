package com.example.java8.fetures.threadExamples;

public class CreateThreadByThread extends Thread {

    public CreateThreadByThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("MyThread.. START:" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread.. END " + Thread.currentThread().getName());

    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }
}
