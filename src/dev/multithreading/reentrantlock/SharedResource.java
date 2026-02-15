package dev.multithreading.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;

    ReentrantLock lock = new ReentrantLock();

    public void producer() {
        lock.lock();
        try {
                System.out.println("Lock acquired by thread: " + Thread.currentThread().getName());
               isAvailable = true;
               Thread.sleep(5000);
        }
        catch (InterruptedException e){

        } finally{
            lock.unlock();
            System.out.println("Lock released by  thread: " + Thread.currentThread().getName());
        }
    }
}
