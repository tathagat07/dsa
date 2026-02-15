package dev.lpa;

public class SharedResourceExample {
    boolean isItemPresent = false;

    public synchronized void addItem(){
        isItemPresent = true;
        System.out.println("Producer thread calling the notify method: " + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void consumeItem()  {
        System.out.println("Consumer thread inside the consumeItem method: " + Thread.currentThread().getName());
        while(!isItemPresent){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isItemPresent = false;
    }

    public static void main(String[] args) {
        SharedResourceExample sharedResource = new SharedResourceExample();

        Thread producerThread = new Thread(
                () -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    sharedResource.addItem();
                }
        );
        Thread consumerThread = new Thread(
                () -> {
                    sharedResource.consumeItem();
                }
        );
        producerThread.start();
        consumerThread.start();
    }
}
