package dev.multithreading.atomic;

public class Main {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Thread th1 = new Thread(() -> {
            for(int i=0; i<200;i++){
                resource.counter();
            }

        });

        Thread th2 = new Thread(() -> {
            for(int i=0; i<200;i++){
                resource.counter();
            }

        });

        Thread th3 = new Thread(() -> {
            for(int i=0; i<200;i++){
                resource.counter();
            }

        });

        th1.start();
        th2.start();
        th3.start();

        try{
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final counter value: " + resource.get());
    }
}
