package com.example.java8.fetures.threadExamples.callableExamples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/*
Java Callable tasks return java.util.concurrent.Future object.
Future Object provides :
   get() method that can wait for the Callable to finish and then return the result.
   cancel() method to cancel the associated Callable task.
   version of get()  specify the time to wait for result. Useful to avoid current thread getting blocked for longer time.
   isDone() - find out the current status
   isCancelled() - find out the current status


  ****> To simulate executions of tasks in parallel, we can use:
     Executor framework

   Java Future is used to get the result of the submitted tasks
 */

/*
Once we execute, you will notice the delay in output because java Future get() method waits for the java callable task to complete.
 Also notice that there are only 10 threads executing these tasks.
Here is snippet of the output of above program.
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Calling call method");
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }

    public static void main(String args[]) {
        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        //Create MyCallable instance
        Callable<String> callable = new MyCallable();
        //submit Callable tasks to be executed by thread pool and
        //add Future to the list, we can get return value using Future
        for(int i=0; i< 100; i++){
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor.submit(callable);
            //add Future to the list, we can get return value using Future
            list.add(future);
        }

        //print the return value of Future, notice the output delay in console
        // because Future.get() waits for task to get completed
        list.forEach(stringFuture -> {
            try {
                System.out.println(new Date() + "::" + stringFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });


        //shut down the executor service now
        executor.shutdown();
    }
}
