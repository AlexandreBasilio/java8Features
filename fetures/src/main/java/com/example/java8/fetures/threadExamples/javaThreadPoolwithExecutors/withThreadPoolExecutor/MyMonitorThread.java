package com.example.java8.fetures.threadExamples.javaThreadPoolwithExecutors.withThreadPoolExecutor;

import java.util.concurrent.ThreadPoolExecutor;

public class MyMonitorThread implements Runnable {

    private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run = true;

    // Here , I say:
    // Use this ThreadPoolExecutor that i will configure before to send to show a monitor about the executor
    // use this seconds to determine the timeout
    public MyMonitorThread(ThreadPoolExecutor executor, int seconds) {
        this.executor = executor;
        this.seconds = seconds;
    }

    public void shutdown() {
        this.run = false;
    }

    /*
      ThreadPoolExecutor provides several methods
       the current state of the executor
       pool size
       active thread count
       task count

       So I have a monitor thread that will print the executor information at a certain time interval.
     */
    @Override
    public void run() {
        while(run){
            System.out.println(
                    String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                            this.executor.getPoolSize(),
                            this.executor.getCorePoolSize(),
                            this.executor.getActiveCount(),
                            this.executor.getCompletedTaskCount(),
                            this.executor.getTaskCount(),
                            this.executor.isShutdown(),
                            this.executor.isTerminated()));
            try {
                Thread.sleep(seconds*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
