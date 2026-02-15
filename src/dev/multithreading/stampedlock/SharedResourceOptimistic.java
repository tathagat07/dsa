package dev.multithreading.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class SharedResourceOptimistic {
    int a = 10;
    StampedLock lock = new StampedLock();

    public void producer(){
        long stamp = lock.tryOptimisticRead();

        try{
            System.out.println("Optimistic Read Lock acquired by thread: " + Thread.currentThread().getName());
            a = 11;
            Thread.sleep(6000);
            if (lock.validate(stamp)) {
                System.out.println("updated a value: " + a);
            } else {
                System.out.println("Roll back : " + Thread.currentThread().getName());
                a=10;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consumer()  {
        long stamp = lock.writeLock();
        System.out.println(" Write Lock acquired by thread: " + Thread.currentThread().getName());

        try {
            System.out.println("Performing tasks in consumer");
            a =9;
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Write Lock released by thread: " + Thread.currentThread().getName());
        }
    }
}
