package com.d3.prac.blockingqueue.main;

import com.d3.prac.blockingqueue.model.Message;
import com.d3.prac.blockingqueue.processors.Consumer;
import com.d3.prac.blockingqueue.processors.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueMain {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        System.out.println("Producer and Consumer has been started");
    }
}
