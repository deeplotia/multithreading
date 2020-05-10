package com.d3.prac.blockingqueue.processors;

import com.d3.prac.blockingqueue.model.Message;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("" + i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produced = " + msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            queue.put(new Message("exit"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
