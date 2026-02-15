package dev.lpa;

public class MonitorLockExample {

    public synchronized void task1(){
        try{
            System.out.println("Task 1 started by: " + Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.println("Task 1 completed by: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void task2(){
        System.out.println("Task 2 before synchronized: "+ Thread.currentThread().getName());
        // This method is not synchronized, so it can be executed by multiple threads simultaneously
        synchronized (this){
            try{
                System.out.println("Task 2 started by: " + Thread.currentThread().getName());
                System.out.println("Task 2 completed by: " + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void task3(){
        System.out.println("Task 3 started by: " + Thread.currentThread().getName());
        // This method is not synchronized, so it can be executed by multiple threads simultaneously
    }

    public static void main(String[] args) {
        MonitorLockExample  obj = new MonitorLockExample();
        Thread t1 = new Thread(()-> obj.task1());
        Thread t2 = new Thread(()-> obj.task2());
        Thread t3 = new Thread(()-> obj.task3());

        t1.start();
        t2.start();
        t3.start();
    }
}
