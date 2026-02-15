package dev.multithreading.producerconsumerlearning;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerLearning {

    private Queue<Integer> sharedBuffer;

    private int bufferSize;

    public ProducerConsumerLearning(int bufferSize) {
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws Exception{

        while (sharedBuffer.size() == bufferSize) {
            System.out.println("Buffer is full, waiting for consumer to consume...");
            wait(); // Wait until there is space in the buffer
        }

        sharedBuffer.add(item);
        System.out.println("Produced: " + item);
        notifyAll(); // Notify consumers that an item has been produced
    }

    public synchronized int consume() throws Exception {

        while (sharedBuffer.isEmpty()) {
            System.out.println("Buffer is empty, waiting for producer to produce...");
            wait(); // Wait until there is an item to consume
        }

        int item = sharedBuffer.poll();
        System.out.println("Consumed: " + item);
        notifyAll(); // Notify producers that an item has been consumed
        return item;
    }
}
