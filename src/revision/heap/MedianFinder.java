package revision.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    public MedianFinder() {
        this.maxheap = new PriorityQueue<>(Collections.reverseOrder());
        this.minheap = new PriorityQueue<>();
    }

    // add value
    private void addNum (int num){
        maxheap.offer(num);

        minheap.offer(maxheap.poll());

        if (minheap.size() > maxheap.size()){
            maxheap.offer(minheap.poll());
        }
    }

    public double findMedian(){
        if(maxheap.size() < minheap.size()){
            return maxheap.peek();
        }

        return (minheap.peek() + maxheap.peek()) / 2.0;
    }
}
