package com.example.java8.fetures.threadExamples.javaThreadPoolwithExecutors.withExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Executors class provide simple implementation of ExecutorService using ThreadPoolExecutor

we are creating a fixed-size thread pool of 5 worker threads.
 Then we are submitting 10 jobs to this pool.
 Since the pool size is 5, it will start working on 5 jobs and other jobs will be in wait state,

 As soon as one of the job is finished, another job from the wait queue will be picked up by worker thread and get’s executed.
 */
public class SimpleThreadPoolWithExecutorService {

    public static void main(String[] args) {

        //where we are creating fixed thread pool from Executors framework.
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            // creating Thread 10
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        System.out.println("SAIH DO FOR ***********");
        // shutdown when tasks submitted are executed. Do not accept new tasks
        executor.shutdown();
       // executor.execute( new WorkerThread("11")); erro: rejected tasks... Do not accept new tasks
        System.out.println("**** EXCUTOR SHUTDOWNED");
        // if all tasks have completed following shut down.
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
