package dev.multithreading;

public class PrintSequentialNumberRevision {
    private int number = 1;
    private int turn = 1;

    public synchronized void printNumbers(int threadId,int max){
        while(number <= max){
            while (threadId != turn){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if(number > max){
                notifyAll();
                break;
            }
            System.out.println("threadId "+threadId + ": " + number++);
            turn = (turn %3) + 1;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        PrintSequentialNumberRevision print = new PrintSequentialNumberRevision();
        int maxNumber = 50;
        Thread th1 = new Thread(() -> print.printNumbers(1,maxNumber));
        Thread th2 = new Thread(() -> print.printNumbers(2,maxNumber));
        Thread th3 = new Thread(() -> print.printNumbers(3,maxNumber));

        th1.start();
        th2.start();
        th3.start();
    }
}
