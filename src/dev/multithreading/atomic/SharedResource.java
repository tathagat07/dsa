package dev.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {
    AtomicInteger counter = new AtomicInteger(0);

    public  void counter() {
        counter.incrementAndGet();
    }

  public  int get(){
        return counter.get();
    }

}
