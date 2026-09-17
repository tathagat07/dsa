package patternbased.multithreading;

public class PrintSequentialCharecter {

    private char currChar = 'A';
    private char maxChar = 'Z';
    private int turn = 1;

    public synchronized void printCharactor(int threadId, char maxChar){

        while (currChar <= maxChar){
            while (threadId != turn){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (currChar > maxChar){
                notifyAll();
                break;
            }

            System.out.println(threadId + ": " + currChar++);
            turn = (turn % 3) + 1;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        PrintSequentialCharecter printSequentialCharecter = new PrintSequentialCharecter();
        char maxChar = 'Z';
        Thread th1 = new Thread(() -> printSequentialCharecter.printCharactor(1,maxChar));
        Thread th2 = new Thread(() -> printSequentialCharecter.printCharactor(2,maxChar));
        Thread th3 = new Thread(() -> printSequentialCharecter.printCharactor(3,maxChar));

        th1.start();
        th2.start();
        th3.start();
    }
}
