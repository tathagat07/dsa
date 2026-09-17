package patternbased.multithreading;

public class PrintSequentialNumber {

    private int number = 1;
    private int turn = 1;

    public synchronized void printNumber(int threadId, int max){

        while (number <= max){
            while (threadId != turn){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (number > max){
                notifyAll();
                break;
            }

            System.out.println(threadId + ": " + number++);
            turn = (turn % 3) + 1;
            notifyAll();
        }
    }

    public static void main(String[] args) {

        PrintSequentialNumber sequentialNumber = new PrintSequentialNumber();
        int maxNumber = 50;
        Thread th1 = new Thread(() -> sequentialNumber.printNumber(1,maxNumber) );
        Thread th2 = new Thread(() -> sequentialNumber.printNumber(2,maxNumber) );
        Thread th3 = new Thread(() -> sequentialNumber.printNumber(3,maxNumber) );

        th1.start();
        th2.start();
        th3.start();
    }
}
