package revision.heap;

import java.util.*;

public class Heap {
    // find kth largest number
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            if(minHeap.size() < k){
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.size();
    }

    public int[] topKFrequent(int[] nums, int k){
        Map<Integer,Integer> freqMap = new HashMap<>();

        // count frequency
        for (int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>(
                (a,b) -> a.getValue() - b.getValue()
        );
        // Step 3: Keep only top K frequent elements
        for (Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            if(priorityQueue.size() < k){
                priorityQueue.offer(entry);
            } else if (entry.getValue() > priorityQueue.peek().getValue()){
                priorityQueue.poll();

                priorityQueue.offer(entry);
            }
        }
        // Step 4: Build answer
        int[] result = new int[k];
        int index = 0;
        while (!priorityQueue.isEmpty()){
            result[index++] = priorityQueue.poll().getKey();
        }
        return result;
    }

    public List<String> topKFrequentWord(String[] words, int k){
        Map<String,Integer> freq = new HashMap<>();

        for (String word : words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<String> pq = new PriorityQueue<>(
                (a,b) -> {
                    if(freq.get(a).equals(freq.get(b))){
                        return b.compareTo(a);
                    }
                    return freq.get(a) - freq.get(b);
                }
        );

        for (String word : freq.keySet()){
            pq.offer(word);

            if (pq.size() > k){
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()){
            result.add(pq.poll());
        }

        Collections.reverse(result);
        return result;
    }

    public int[][] findKClosest(int[][] points, int k){
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a,b) -> distance(a) - distance(b)
        );

        for (int[] point : points){
            if (minHeap.size() < k){
                minHeap.offer(point);
            } else if (distance(point) > distance(minHeap.peek())){
                minHeap.poll();
                minHeap.offer(point);
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (!minHeap.isEmpty()){
           result[index++] = minHeap.poll();
        }
        return result;
    }


    private int distance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }

    // merge K list
     public ListNode mergeKList(ListNode[] lists ){
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>();

         // Add the head of every non-empty list
         for (ListNode node : lists){
             if (node != null){
                 minHeap.offer(node);
             }
         }

         ListNode dummy = new ListNode(-1);
         ListNode tail = dummy;

         while (!minHeap.isEmpty()){
             ListNode smallest = minHeap.poll();

             tail.next = smallest;
             tail = tail.next;

             if (smallest.next != null){
                 minHeap.offer(smallest.next);
             }
         }
        return dummy.next;
     }

}
