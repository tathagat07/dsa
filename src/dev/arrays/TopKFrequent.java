package dev.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public int[] topKFreq(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );

        for (int num : map.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];

        for(int i = k-1 ; i>= 0 ; i--){
            res[i] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1,1,1,1,2,2, 2, 2, 3,4,4,4};
        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println(Arrays.toString(topKFrequent.topKFreq(nums, 3)));
    }

}




