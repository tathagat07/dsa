package dev.arrays;

import java.util.*;

public class MinDiff {


    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        for(int i = 1; i< n ; i++){
            prefix[i] = prefix[i -1] * nums[i -1];
        }
        for (int j = n-2; j>=0; j--){
            suffix[j] = suffix[j+1] * nums[j+1];
        }

        for(int i = 0; i< n; i++){
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i = 0; i< nums.length; i++){
              if(set.contains(nums[i])){
                  ans = nums[i];
              } else {
                  set.add(nums[i]);
              }
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>();
       map.put(0,1);
       int ans = 0;
       int sum = 0;

       for(int i=0; i< nums.length; i++){
           sum += nums[i];

           if(map.containsKey(sum - k)){
               ans+= map.get(sum -k);
           }

           if(map.containsKey(sum)){
               map.put(sum, map.get(sum) +1);
           } else {
               map.put(sum,1);
           }

       }
       return ans;

    }

    public static int maxAreaBrute(int[] height){
     int maxArea = 0;
     int currentArea = 0;
     int n = height.length;
     for(int lb = 0; lb < n ; lb++){
         for(int rb = lb +1; rb < n ; rb++ ){
             currentArea = (rb - lb) * Math.min(height[rb],height[lb]);
             maxArea = Math.max(currentArea,maxArea);
         }
     }
      return maxArea;
    }

    public static int maxAreaTwoPointer(int[] height){
        int n = height.length;
        int left = 0;
        int right = n-1;
        int currArea = 0;
        int maxArea = 0;

        while (left < right){
            int leftHeight = height[left];
            int rightHeight = height[right];

            currArea = (right - left) * Math.min(height[left], height[right]);
            maxArea    = Math.max(maxArea,currArea);
            if(height[left] > height[right]){
                right--;
            } else {
                left++;
            }

        }

        return maxArea;

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0 ;
        int bestBuy = prices[0];

        for(int i = 0; i< prices.length; i++){
            if(prices[i] > bestBuy){
                maxProfit = Math.max(maxProfit, prices[i] - bestBuy);
            }

            bestBuy = Math.min(bestBuy,prices[i]);
        }
        return maxProfit;

    }


    public static int search(int[] arr, int target){
        int left = 0, right = arr.length -1;

        while(left <= right){
            int mid = left + (right - left )/2;

            if(arr[mid] == target){
                return mid;
            }
           if(arr[left] < arr[mid]){
               if (target >= arr [left] && target < arr [mid]){
                   right = right -1;
               } else {
                   left = left + 1;
               }
           } else {
               if (target >= arr [mid] && target < arr [right]){
                   right = right -1;
               } else {
                   left = left + 1;
               }
           }


        }

        return -1;
    }
    public static int findMinDiff(int[] nums, int m){

       Arrays.sort(nums);
       int minDiff = Integer.MAX_VALUE;
       for(int i = 0 ; i + m -1 <nums.length; i++){
           int diff = nums[i + m - 1] - nums[i];
           minDiff = Math.min(diff,minDiff);

       }
       return minDiff;
    }

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

    public int singleNumber(int[] nums) {
        int result  = 0;
        for(int num: nums){
            result ^= num;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int[] prices = {7,1,5,3,6,4};
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[][] grid = {{1,3},{2,2}};
        int target = 3 ;
     //   int m = 5;
     // System.out.println(search(arr, target));
      //  System.out.println(maxProfit(prices));
     //   System.out.println((maxAreaTwoPointer(height)));
        int[] ans = new int[2];
  //      ans = findMissingAndRepeatedValues(grid);
        for(int i = 0; i< ans.length; i++){
            System.out.println(ans[i]);
        }

//       System.out.println(findMinDiff(arr, m));
    }
}
