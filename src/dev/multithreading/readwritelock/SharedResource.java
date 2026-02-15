package dev.multithreading.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {
    boolean isAvailable = false;


    public void producer(ReadWriteLock lock) {
        lock.readLock().lock();
        try {
             System.out.println("Read Lock acquired by thread: " + Thread.currentThread().getName());

               Thread.sleep(4000);
        }
        catch (InterruptedException e){

        } finally{
            lock.readLock().unlock();
            System.out.println("Read Lock released by  thread: " + Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock lock) {
        lock.writeLock().lock();
        try {
            System.out.println("Write Lock acquired by thread: " + Thread.currentThread().getName());
             isAvailable = false;
            Thread.sleep(4000);
        }
        catch (InterruptedException e){

        } finally{
            lock.writeLock().unlock();
            System.out.println("Write Lock released by  thread: " + Thread.currentThread().getName());
        }
    }
}
