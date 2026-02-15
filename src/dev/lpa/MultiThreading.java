package dev.lpa;

public class MultiThreading implements Runnable
{
    @Override
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
}
