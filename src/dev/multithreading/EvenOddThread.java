package dev.multithreading;

public class EvenOddThread {
    private int number = 1;

    private final int max = 50;

    public synchronized void printOdd(){
        while(number<=max){
            while(number % 2 == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while(number > max){
                notifyAll();
                break;
            }

            System.out.println("Odd thread: "+number++);
            notifyAll();
        }
    }
    public synchronized void printEven(){
        while(number<=max){
            while(number % 2 != 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while(number > max){
                notifyAll();
                break;
            }

            System.out.println("Even thread: "+number++);
            notifyAll();
        }
    }

    public static void main(String[] args) {
        EvenOddThread evenOddThread = new EvenOddThread();

        Thread oddThread = new Thread(()-> evenOddThread.printOdd());
        Thread evenThread = new Thread(()-> evenOddThread.printEven());
        oddThread.start();
        evenThread.start();
    }

}
