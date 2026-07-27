package patternbased.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Heap {

    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){

            if(minHeap.size() < k){
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }

    public int[] topKFrequent(int[] nums, int k){
        Map<Integer,Integer> freq = new HashMap<>();

        // Step 1: Count frequency
        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        // Step 2: Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
                (a,b) -> a.getValue() - b.getValue()
        );
        // Step 3: Keep only top K frequent elements
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                  minHeap.poll();
                  minHeap.offer(entry);
            }
        }

        // Step 4: Build answer
        int[] result = new int[k];
        int index = 0;

        while (!minHeap.isEmpty()){
            result[index++] = minHeap.poll().getKey();
        }
        return result;
    }

    public int[][] kClosest(int[][] points, int k){
       PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
               (a,b) -> distance(b) - distance(a)
       );

       for(int[] point : points){
           if(maxHeap.size() < k){
               maxHeap.offer(point);
           } else if (distance(point) < distance(maxHeap.peek())) {
                 maxHeap.poll();
                 maxHeap.offer(point);
           }
       }

       int[][] result = new int[k][2];
       int index = 0;

       while (!maxHeap.isEmpty()){
           result[index++] = maxHeap.poll();
       }

       return result;
    }

    private int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }

   public int findKthLargestRev(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            if(minHeap.size() < k){
                minHeap.offer(num);
            }

            if(num > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(num);
            }

        }
        return minHeap.peek();
   }

    public int[] topKFrequentRev(int[] nums, int k){
        Map<Integer,Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
                (a,b) -> a.getValue() - b.getValue()
        );

        // Step 3: Keep only top K frequent elements

        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            } else if(entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        int[] result = new int[k];
        int index = 0;

        while (!minHeap.isEmpty()){
            result[index++] = minHeap.poll().getKey();
        }
        return result;
    }
}
