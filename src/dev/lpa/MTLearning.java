package dev.lpa;

public class MTLearning {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource(5);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 6; i++) {
                    resource.produce(i);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 6; i++) {
                    resource.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}
