package com.example.java8.fetures.threadExamples.callableWithFutureTaskExamples;

import org.springframework.core.task.support.ExecutorServiceAdapter;

import java.util.concurrent.*;

/*

FutureTask is base concrete implementation of Future interface and provides asynchronous processing.
  FutureTask contains:
     methods to start and cancel a task
     methods that can return the state of the FutureTask as whether it’s completed or cancelled.

We need a callable object to create a future task and then we can use Java Thread Pool Executor to process these asynchronously.

 */
public class FutureTaskExample {

    public static void main(String[] args) {
        MyCallable callable1 = new MyCallable(1000);
        MyCallable callable2 = new MyCallable(2000);

        FutureTask<String> futureTask1 = new FutureTask<>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<>(callable2);

        //Get ExecutorService from Executors utility class, thread pool size is 2
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(futureTask1);
        executor.execute(futureTask2);

        int i = 0;
        while (true) {
            i++;
            System.out.println("cont=" + i);
            try {
                if (futureTask1.isDone() && futureTask2.isDone()) {
                    executor.shutdown();
                    return;
                }

                if (!futureTask1.isDone()) {
                    System.out.println("esperando indefinitivamente... FutureTask1 output=" + futureTask1.get());
                }

                System.out.println("waiting for futureTask2 to complete");
                // get() method of FutureTask waits for the task to get completed and then returns the output object.
                /*
                As such there is no benefit of FutureTask but it comes handy
                when we want to override some of Future interface methods and don’t want to implement every method of Future interface.
                 */
                String s = futureTask2.get(2000L, TimeUnit.MILLISECONDS);
                if (s != null) {
                    System.out.println("Future task2=" + s + " done? = " + futureTask2.isDone());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("timeout");
            }

        }
    }
}
