package com.example.java8.fetures.threadExamples.blockingQueueConsumerProducerProblem;

import java.util.concurrent.BlockingQueue;

/*
 Producer class that will create messages and put it in the queue.
 */
public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    // passo uma queue em branco ou com alguma coisa ja dentro
    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            Message msg = new Message("msg"+i);

            try {
                Thread.sleep(i);
                // put -> Inserts the specified element into this queue
                queue.put(msg);
                System.out.println("Produced="+msg.getMsg() + " queue_reference=" + queue.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // add exit message
        Message msg = new Message("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  BlockingQueue<Message> getQueue() {
        return queue;
    }
}
