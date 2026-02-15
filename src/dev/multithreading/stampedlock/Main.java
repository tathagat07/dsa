package dev.multithreading.stampedlock;



public class Main {
    public static void main(String[] args) {
       // SharedResource resource = new SharedResource();
        SharedResourceOptimistic resource = new SharedResourceOptimistic();

        Thread th1 = new Thread(() -> {
            resource.producer();
        });

        Thread th2 = new Thread(() -> {
            resource.producer();
        });

        Thread th3 = new Thread(() -> {

                resource.consumer();

        });
        th1.start();
        th2.start();
        th3.start();
    }
}
