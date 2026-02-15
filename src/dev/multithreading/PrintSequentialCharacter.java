package dev.multithreading;

public class PrintSequentialCharacter {
    private char currentChar = 'A'; // Start with 'A'
    private int turn = 1;

    public synchronized void print(int threadId, char maxChar) {
        while (currentChar <= maxChar) {
            while (turn != threadId) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (currentChar > maxChar) {
                notifyAll();
                break;
            }
            System.out.println("Thread " + threadId + ": " + currentChar++);
            turn = (turn % 3) + 1;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        PrintSequentialCharacter printCharacters = new PrintSequentialCharacter();
        char maxChar = 'Z'; // Maximum character to print

        Thread t1 = new Thread(() -> printCharacters.print(1, maxChar));
        Thread t2 = new Thread(() -> printCharacters.print(2, maxChar));
        Thread t3 = new Thread(() -> printCharacters.print(3, maxChar));

        t1.start();
        t2.start();
        t3.start();
    }
}
