package com.example.java8.fetures.threadExamples.blockingQueueConsumerProducerProblem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
 Normal java object that will be produced by Producer and
 added to the queue.

 You can also call it as payload or queue message.
 */
@Getter
@Setter
@AllArgsConstructor
public class Message {

    private String msg;
}
