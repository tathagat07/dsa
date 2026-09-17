package patternbased.multithreading;

public class EvenOddThread {

    private int number = 1;

    private int max = 50;

    public synchronized void printOdd(){
        while (number <= max){
            while (number % 2 ==0){

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

            System.out.println("Odd Thread : "+ number++);
            notifyAll();
        }

    }

    public synchronized void printEven(){
        while (number <= max){
            while (number % 2 !=0){

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

            System.out.println("Even Thread : "+ number++);
            notifyAll();
        }

    }

    public static void main(String[] args) {

        EvenOddThread thread = new EvenOddThread();

        Thread evenThread = new Thread( () -> thread.printEven());
        Thread oddThread = new Thread( () -> thread.printOdd());

        evenThread.start();
        oddThread.start();
    }

}
