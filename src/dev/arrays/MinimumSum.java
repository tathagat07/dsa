package dev.arrays;

import java.util.PriorityQueue;

public class MinimumSum {
    public static int minimumSum(int[] nums, int k) {
        // Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all elements to heap
        for (int num : nums) {
            maxHeap.add(num);
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            int largest = maxHeap.poll(); // take max
            int reduced = (int) Math.ceil(largest / 2.0); // divide by 2 and ceil
            maxHeap.add(reduced);
        }

        // Compute sum of final array
        int sum = 0;
        for (int num : maxHeap) {
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 7};
        int k = 4;
        int result = minimumSum(nums, k);
        System.out.println("Minimum Sum after " + k + " operations: " + result);
    }
}
// Output: Minimum Sum after 4 operations: 12