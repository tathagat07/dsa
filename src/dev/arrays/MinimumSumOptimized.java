package dev.arrays;

import java.util.PriorityQueue;

public class MinimumSumOptimized {
    public static int minimumSum(int[] nums, int k) {
        // Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all elements to heap
        for (int num : nums) {
            maxHeap.add(num);
        }

        // Perform at most k operations or until all numbers become 1
        while (k > 0 && maxHeap.peek() > 1) {
            int largest = maxHeap.poll();
            int reduced = (largest + 1) / 2; // faster than ceil(largest/2.0)
            maxHeap.add(reduced);
            k--;
        }

        // If we still have operations left, they won't change anything (all are 1s)
        int sum = 0;
        for (int num : maxHeap) {
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {10,20,7};
        int k = 4;
        int result = minimumSum(nums, k);
        System.out.println("Minimum Sum after " + k + " operations: " + result);
    }
}

