package dev.multithreading.producerconsumerlearning;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerLearningRev {
    private Queue<Integer> sharedBuffer;

    private int bufferSize;

    public ProducerConsumerLearningRev(int bufferSize) {
        this.sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws Exception{
      while(sharedBuffer.size() == bufferSize){
          System.out.println("Buffer is full, waiting for consumer to consume...");
          wait();
      }

      sharedBuffer.add(item);
      System.out.println("Produced: " + item);
      notifyAll();
    }

    public synchronized void consume() throws Exception{
        while (sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty, waiting for producer to produce...");
            wait();
        }

        int item = sharedBuffer.poll();
        System.out.println("Consumed: " + item);
        notifyAll();
    }

    public static void main(String[] args) {
        ProducerConsumerLearningRev plearn = new ProducerConsumerLearningRev(4);
        Thread producer = new Thread(
                () -> {
                   for(int i = 0 ; i<=6 ; i++){
                       try {
                           plearn.produce(i);
                       } catch (Exception e) {
                           throw new RuntimeException(e);
                       }
                   }
                }
        );

        Thread consumer = new Thread(() -> {
            for(int i = 0; i<=6; i ++){
                try {
                    plearn.consume();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
