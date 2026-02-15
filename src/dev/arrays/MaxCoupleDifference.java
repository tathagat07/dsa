package dev.arrays;

public class MaxCoupleDifference {

    public static int maxDifference(int[] nums) {
        int n = nums.length;
        int maxDiff = Integer.MIN_VALUE;

        // Pick 4 distinct numbers (i, j, k, l) with no consecutive indices
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) { // ensure not consecutive
                for (int k = j + 2; k < n; k++) {
                    for (int l = k + 2; l < n; l++) {
                        int a = nums[i], b = nums[j], c = nums[k], d = nums[l];

                        // We can form couples in 3 ways
                        int diff1 = Math.abs((a * b) - (c * d));
                        int diff2 = Math.abs((a * c) - (b * d));
                        int diff3 = Math.abs((a * d) - (b * c));

                        maxDiff = Math.max(maxDiff, Math.max(diff1, Math.max(diff2, diff3)));
                    }
                }
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 5, 6, 7, 8, 9};
        int result = maxDifference(nums);
        System.out.println("Maximum difference: " + result);
    }
}

