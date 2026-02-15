package dev.lpa;

public class DaemonThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread daemonThread = new Thread(() -> {
            try {
                System.out.println("Daemon thread starts");
                Thread.sleep(3000);
                System.out.println("This will likely not be printed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        Thread nonDaemonThread = new Thread(() -> {
            try {
                System.out.println("Non-daemon thread starts");
                Thread.sleep(1000);
                System.out.println("Non-daemon thread ends");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        nonDaemonThread.start();

        // Main thread waits for non-daemon thread to finish
        nonDaemonThread.join();
        System.out.println("Main thread ends");

        // JVM exits here, daemon thread is abandoned
    }
}
