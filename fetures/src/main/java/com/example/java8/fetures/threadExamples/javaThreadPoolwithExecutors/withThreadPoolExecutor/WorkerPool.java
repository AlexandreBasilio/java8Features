package com.example.java8.fetures.threadExamples.javaThreadPoolwithExecutors.withThreadPoolExecutor;

import com.example.java8.fetures.threadExamples.javaThreadPoolwithExecutors.withExecutorService.WorkerThread;

import java.util.concurrent.*;

public class WorkerPool {
    public static void main(String args[]) throws InterruptedException{
        //RejectedExecutionHandler implementation
        // rejectedExecution: tipo un listener que  identifica threads rejeitadas
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();

        //Get the ThreadFactory implementation to use
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        //creating the ThreadPoolExecutor
        // we are keeping initial pool size as 2, maximum pool size to 4 and work queue size as 2.
        // So if there are 4 running tasks and more tasks are submitted
        // , the work queue will hold only 2 of them and the rest of them will be handled by RejectedExecutionHandlerImpl.
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);

        //start the monitoring thread
        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        //submit work to the thread pool
        for(int i=0; i<10; i++){
            executorPool.execute(new WorkerThread("cmd"+i));
        }

        Thread.sleep(30000);

        //shut down the pool
        executorPool.shutdown();

        //shut down the monitor thread
        Thread.sleep(5000);
        monitor.shutdown();

    }
}
