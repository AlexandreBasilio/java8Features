package com.example.java8.fetures.threadExamples.javaThreadPoolwithExecutors.withExecutorService;

public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start. Command=" + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " end.");
    }

    @Override
    public String toString() {
        return this.command;
    }


    private void processCommand() {
        try {
            //if (command.equalsIgnoreCase("1")) {
                System.out.println("fazendo tarefa " + command);
           //     Thread.sleep(10000);
           // } else {
                Thread.sleep(5000);
           //     System.out.println("fazendo outras tarefas " + command);
           // }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
