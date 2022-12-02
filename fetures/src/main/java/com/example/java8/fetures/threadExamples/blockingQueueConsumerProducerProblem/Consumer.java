package com.example.java8.fetures.threadExamples.blockingQueueConsumerProducerProblem;

import java.util.concurrent.BlockingQueue;

/*
  Will process on the messages from the queue and terminates when exit message is received.
 */
public class Consumer implements Runnable {

    private BlockingQueue<Message> queue;

    // passou uma queue sem nada ou com algo dentro
    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Message msg;
        try {
            //  queue.take() ->  Retrieves and removes the head of this queue
            while((msg = queue.take()).getMsg() !="exit") {
                Thread.sleep(10);
                System.out.println("  >> consumed:" + queue.take().getMsg() + " queue_reference=" + queue.toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}