package dev.multithreading;

public class PrintSequentialNumber {
  private int number = 1;
  private int turn = 1;

  public synchronized void printNumbers(int threadId, int max){

      while(number <= max){
           while(threadId != turn){
               try {
                   wait();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }


           }

           if(number > max){
               notifyAll();;
               break;
           }

          System.out.println(threadId + ": " + number++);
          turn = (turn % 3 ) +1;
          notifyAll();

      }



  }


    public static void main(String[] args) {
         int max = 50;
         PrintSequentialNumber print = new PrintSequentialNumber();

         Thread th1 = new Thread(() -> print.printNumbers(1,max));
        Thread th2 = new Thread(() -> print.printNumbers(2,max));
        Thread th3 = new Thread(() -> print.printNumbers(3,max));

        th1.start();
        th2.start();
        th3.start();

    }
}
