package revision.arrays;

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        for(int i=0; i< n; i++){
            if(hashmap.containsKey(nums[i])){
                hashmap.put(nums[i], hashmap.get(nums[i]) + 1);
            } else {
                hashmap.put(nums[i],1);
            }
        }

        for(int key : hashmap.keySet()){
            if(hashmap.get(key) > n/2){
                ans = key;
            }
        }
        return ans;
    }

    public int trap(int[] height) {
        int n = height.length;

        int ans = 0;
        int lmax = height[0];  // Maximum height on the left
        int rmax = height[n - 1];  // Maximum height on the right
        int low = 1;  // Pointer from the left
        int high = n - 2;  // Pointer from the right


        while (low <= high) {
            lmax = Math.max(lmax, height[low]);
            rmax = Math.max(rmax, height[high]);


            if (lmax < rmax) {
                ans += lmax - height[low];
                low++;
            } else {
                ans += rmax - height[high];
                high--;
            }
        }
        return ans;
    }

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

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] result = new int[2];

        int a = 0;
        int b = 0;
        int actualSum = 0;
        int expectedSum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< n ; i++){
            for (int j = 0; j <n; j++){
                actualSum += grid[i][j];
                if(set.contains(grid[i][j])){
                    a = grid[i][j];
                    result[0] = a;
                } else {
                    set.add(grid[i][j]);
                }
            }
        }

        expectedSum = (n*n)*(n*n + 1)/2;
        b = expectedSum + a - actualSum;
        result[1] = b;

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>(new ArrayList<>());
        for(int i = 0; i< n; i++){
            if(i> 0 && nums[i] == nums[i-1]){
                continue;
            }

            int j = i+1;
            int k = n-1;

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum >0){
                    k--;
                } else if (sum < 0){
                    j++;
                } else {
                    List<Integer> ans1 = new ArrayList<>();
                    ans1.add(nums[i]);
                    ans1.add(nums[j]);
                    ans1.add(nums[k]);
                    j++;
                    k--;
                    ans.add(ans1);
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                }
            }
        }

        return ans;
    }
}
