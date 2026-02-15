package dev.multithreading.producerconsumerlearning;

public class Main {

    public static void main(String[] args) {
        ProducerConsumerLearning sharedResource = new ProducerConsumerLearning(4);

        Thread producerThread = new Thread(
            () -> {
                try {
                    for (int i = 1; i <= 6; i++) {
                        sharedResource.produce(i);
//                        Thread.sleep(500); // Simulate time taken to produce an item
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );
        Thread consumerThread = new Thread(
            () -> {
                try {
                    for (int i = 1; i <= 6; i++) {
                        sharedResource.consume();
//                        Thread.sleep(1000); // Simulate time taken to consume an item
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );

        producerThread.start();
        consumerThread.start();
    }
}
