package patternbased.multithreading.producerconsumer;

public class Main {

    public static void main(String[] args) {
        ProducerConsumerLearning sharedResource = new ProducerConsumerLearning(4);

        Thread producer = new Thread(
                () -> {
                    for (int i=0 ; i < 6 ; i++){
                        try {
                            sharedResource.produce(i);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        Thread consumer = new Thread(
                () -> {
                    for (int i=0 ; i < 6 ; i++){
                        try {
                            sharedResource.consume();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        producer.start();
        consumer.start();
    }
}
