package dev.arrays;

public class MaxCoupleDifferenceGreedy {

    public static int maxDifference(int[] nums) {
        int n = nums.length;

        int maxProduct = Integer.MIN_VALUE;
        int minProduct = Integer.MAX_VALUE;

        // Check all valid pairs once (O(n^2))
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) { // ensure non-consecutive
                int product = nums[i] * nums[j];
                maxProduct = Math.max(maxProduct, product);
//                System.out.println("Maximum product: " + maxProduct);
                minProduct = Math.min(minProduct, product);
//                System.out.println("Minimum product: " + minProduct);
            }
        }

        // Maximum difference
        return maxProduct - minProduct;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 5, 6, 7, 8, 9};
        int result = maxDifference(nums);
        System.out.println("Maximum difference: " + result);
    }
}
