package com.example.java8.fetures.threadExamples.blockingQueueConsumerProducerProblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerService {

    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
//        Message x = new Message("oi");
//        Message x2 = new Message("oi");
//        try {
//            queue.put(x);
//            queue.put(x2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(" SIZE... " + queue.size());
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
//
//        //starting producer to produce messages in queue
        Thread t1 = new Thread(producer);
        t1.start();
        //starting consumer to consume messages from queue
        new Thread(consumer).start();

//        while (t1.getState() != Thread.State.TERMINATED) {
//            System.out.println("RPoducer queue" + "state thread t1= " + t1.getState()+ " Size="  +queue.size());
//        }
//

//
//        System.out.println("Producer and Consumer has been started");
//
//        System.out.println(" SIZE " + queue.size());
//        queue.stream().forEach(message -> System.out.println(" MENSAGEM " + message.getMsg()));
    }
}
