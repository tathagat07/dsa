package dev.multithreading.semaphore;



public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread th1 = new Thread(() -> {
            resource.producer();
        });

        Thread th2 = new Thread(() -> {
            resource.producer();
        });

        Thread th3 = new Thread(() -> {
            resource.producer();
        });

        Thread th4 = new Thread(() -> {
            resource.producer();
        });


        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
