package revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {


    public int[] topKfrequent(int[] nums, int k){
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b));

        for(int num : freq.keySet()){
            pq.offer(num);
            if(pq.size()> k){
                pq.poll();
            }
        }

        int[] result = new int[k];

        for(int i = k-1; i>= 0 ;i--  ){
            result[i] = pq.poll();
        }
        return result;
    }

    public int[] topKFrequentRevision(int[] nums, int k){
        Map<Integer,Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0) +1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> freq.get(a) - freq.get(b)
        );

        for(int num : freq.keySet()){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] result = new int[k];

        for(int i = k - 1;i>=0 ;i--){
            result[i] = pq.poll();
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println(Arrays.toString(topKFrequent.topKfrequent(nums, 2)));
    }

}




