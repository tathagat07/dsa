package dev.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class SharedResource {
    boolean isAvailable = false;

    Semaphore semaphore = new Semaphore(2);
       public void producer() {
            try {
                semaphore.acquire();
                System.out.println("Semaphore acquired by thread: " + Thread.currentThread().getName());
                int a = 10;
                System.out.println("Value of a: " + a);
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("Semaphore released by thread: " + Thread.currentThread().getName());
            }
        }
}
