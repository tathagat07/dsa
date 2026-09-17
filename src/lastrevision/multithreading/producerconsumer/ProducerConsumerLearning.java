package patternbased.multithreading.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerLearning {

    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public ProducerConsumerLearning(int bufferSize) {
        this.sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws InterruptedException {

        while (sharedBuffer.size() == bufferSize){
            System.out.println("Buffer is full, waiting for consumer to consume...");
            wait();
        }

        sharedBuffer.add(item);
        System.out.println("Produced: " + item);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {

        while (sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty, waiting for producer to produce...");
            wait();
        }

        int item = sharedBuffer.poll();
        System.out.println("Consumed: " + item);
        notifyAll();
        return item;
    }
}
