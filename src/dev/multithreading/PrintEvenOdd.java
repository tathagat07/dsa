package dev.multithreading;

public class PrintEvenOdd {
    private int number = 1; // Start with 1
    private final int max = 50; // Maximum number to print

    public synchronized void printOdd() {
        while (number <= max) {
            while (number % 2 == 0) { // Wait if the number is even
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number > max) {
                notifyAll();
                break;
            }
            System.out.println("Odd Thread: " + number++);
            notifyAll(); // Notify the even thread
        }
    }

    public synchronized void printEven() {
        while (number <= max) {
            while (number % 2 != 0) { // Wait if the number is odd
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number > max) {
                notifyAll();
                break;
            }
            System.out.println("Even Thread: " + number++);
            notifyAll(); // Notify the odd thread
        }
    }

    public static void main(String[] args) {
        PrintEvenOdd printEvenOdd = new PrintEvenOdd();

        Thread oddThread = new Thread(printEvenOdd::printOdd);
        Thread evenThread = new Thread(printEvenOdd::printEven);

        oddThread.start();
        evenThread.start();
    }
}