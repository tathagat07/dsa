package dev.lpa;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> sharedBuffer;
    private int size;

    public SharedResource( int size) {
        sharedBuffer = new LinkedList<>();
        this.size = size;
    }

    public synchronized void produce(int item) throws Exception {
        while (sharedBuffer.size() == size) {
            System.out.println("Buffer is full, waiting for consumer to consume");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sharedBuffer.add(item);
        System.out.println("Item produced: " + item + " : "+Thread.currentThread().getName() + " Buffer size: " + sharedBuffer.size() + " Buffer: " + sharedBuffer);
        notifyAll();
    }

    public synchronized int consume() throws Exception {
        while (sharedBuffer.isEmpty()) {
            System.out.println("Buffer is empty, waiting for producer to produce");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int item = sharedBuffer.poll();
        System.out.println("Item consumed: " + item + " : " + Thread.currentThread().getName() + " Buffer size: " + sharedBuffer.size() + " Buffer: " + sharedBuffer);
        notifyAll();
        return item;
    }
}
