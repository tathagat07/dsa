package dev.lpa;

public class MyClass  {
    public static void main(String[] args) {
        System.out.println("Going inside the main method: " + Thread.currentThread().getName());
        MultiThreading runnable = new MultiThreading();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Exiting the main method: " + Thread.currentThread().getName());
    }
}
