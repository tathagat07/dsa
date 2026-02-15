package dev.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindSum {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(currSum, maxSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(new ArrayList<>());

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> ans1 = new ArrayList<>();
                    ans1.add(nums[i]);
                    ans1.add(nums[j]);
                    ans1.add(nums[k]);
                    ans.add(ans1);

                    if (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }

        }

        return ans;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>(new ArrayList<>());

        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {

                int p = j + 1;
                int q = n - 1;

                while (p < q) {
                    long sum = nums[i] + nums[j] + nums[p] + nums[q];

                    if (sum > target) {
                        q--;
                    } else if (sum < target) {
                        p++;
                    } else {
                        List<Integer> ans1 = new ArrayList<>();
                        ans1.add(nums[i]);
                        ans1.add(nums[j]);
                        ans1.add(nums[p]);
                        ans1.add(nums[q]);

                        ans.add(ans1);
                        p++;
                        q--;
                        while (p < q && nums[p] == nums[p - 1]) p++;
                    }

                }
                j++;
                while (j < n && nums[j] == nums[j - 1]) j++;

            }


        }
        return ans;
    }



    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int ans = 0;
        int sum = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);

            } else {
                map.put(sum, 1);
            }
        }

        System.out.println(ans);
    }
}
