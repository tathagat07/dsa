package dev.multithreading.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    boolean isAvailable = false;

    StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.readLock();
        try {
            System.out.println("Stamped Read Lock acquired by thread: " + Thread.currentThread().getName());
            int a = 10;
            System.out.println("Value of a: " + a);
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlockRead(stamp);
            System.out.println("Read Lock released by thread: " + Thread.currentThread().getName());
        }
    }

    public void consumer() {
        long stamp = lock.writeLock();
        try {
            System.out.println("Write Lock acquired by thread: " + Thread.currentThread().getName());
            isAvailable = false;
            int a = 11;
            System.out.println("Performing tasks in consumer, updated a value: " + a);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Write Lock released by thread: " + Thread.currentThread().getName());
        }
    }
}
