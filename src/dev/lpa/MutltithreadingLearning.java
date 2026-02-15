package dev.lpa;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MutltithreadingLearning {
    public static void main(String[] args) {
//        System.out.println("Going inside the main method: " + Thread.currentThread().getName());
//        MyClass myClass = new MyClass();
//        Thread thread = new Thread(myClass);
//        thread.start();
//        System.out.println("Exiting the main method: " + Thread.currentThread().getName());

        Resource resource = new Resource();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread th1 = new Thread(() -> {
            resource.producer(lock);
        });

        Thread th2 = new Thread(() -> {
            resource.producer(lock);
        });

        Resource r1 = new Resource();
        Thread th3 = new Thread(() -> {
            r1.consumer(lock);
        });

        th1.start();
        th2.start();
        th3.start();
    }
}
