package dev.collections;

import java.util.PriorityQueue;

public class MinPriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((Integer a, Integer b) -> b -a);
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(8);
        minHeap.add(1);

       minHeap.forEach(i -> System.out.print(i + " "));
        System.out.print("\n");
       while(!minHeap.isEmpty()) {
           System.out.print("removing from top "+minHeap.poll() +"\n");
       }
    }
}
