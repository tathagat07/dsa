package dev.multithreading;

public class PrintSequentialCharacterRev {
    private char currentChar = 'A'; // Start with 'A'
    private int turn = 1;

    public synchronized void printCharectors(int threadId,char maxChar){
        while(currentChar <= maxChar){
            while (threadId != turn){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if(currentChar > maxChar){
                notifyAll();
                break;
            }
            System.out.println("Thread " + threadId + ": " + currentChar++);
            turn = (turn %3) + 1;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        PrintSequentialCharacterRev print = new PrintSequentialCharacterRev();
        char maxChar = 'Z';
        Thread th1 = new Thread(() -> print.printCharectors(1,maxChar));
        Thread th2 = new Thread(() -> print.printCharectors(2,maxChar));
        Thread th3 = new Thread(() -> print.printCharectors(3,maxChar));

        th1.start();
        th2.start();
        th3.start();
    }
}
