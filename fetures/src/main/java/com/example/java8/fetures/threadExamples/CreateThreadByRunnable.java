package com.example.java8.fetures.threadExamples;

public class CreateThreadByRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("doing heavy process.. START:" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doing heavy process.. END " + Thread.currentThread().getName());

    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }
}
