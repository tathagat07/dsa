package patternbased.dynamicprogramming;

import java.util.Arrays;

public class HouseRober {
    private int robRecursion(int[] nums, int i){

        if(i >= nums.length)
            return 0;

        int robCurrent = nums[i] + robRecursion(nums, i + 2);

        int skipCurrent = robRecursion(nums, i + 1);

        return Math.max(robCurrent, skipCurrent);
    }
    // memoized solution
    public int robMemoized(int nums[]){
        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);

        return robMemoized(nums, 0, dp);
    }

    private int robMemoized(int[] nums,
                    int index,
                    int[] dp){

        if(index >= nums.length){
            return 0;
        }

        if(dp[index] != -1){
           return dp[index];
        }

        int robCurrent = nums[index] + robMemoized(nums,index + 2,dp);

        int skipCurrent = robMemoized(nums,index + 1, dp);

        dp[index] = Math.max(robCurrent,skipCurrent);

        return dp[index];
    }


    // optimized solution
    public int rob(int[] nums){
        int n = nums.length;

        int[] dp = new int[n+2];

        for(int i = n -1 ; i >=0 ; i--){
            int rob = nums[i] + dp[i+2];

            int skip = dp[i+1];

            dp[i] = Math.max(rob,skip);

        }
        return dp[0];
    }

    public int maximumNonAdjacentSum(int[] nums){
        int next1 = 0;
        int next2 = 0;

        for(int i = nums.length - 1 ; i >=0; i--){
            int current = Math.max(nums[i] + next2, next1);

            next2 = next1;
            next1 = current;
        }

        return next1;
    }

    public int deleteAndEarn(int[] nums){
        int max = 0;

        for(int num : nums){
            max = Math.max(num,max);
        }

        int[] points = new int[max+1];

        for(int num : nums){
            points[num] += num;
        }

        int prev2 = 0;
        int prev1 = 0;

        for(int point : points){
            int current = Math.max(prev1, prev2 + point);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;

    }

    public static void main(String[] args) {
        HouseRober solver = new HouseRober();

        int[] test1 = {1, 2, 3, 1};
        int[] test2 = {2, 7, 9, 3, 1};
        int[] test3 = {2, 1, 1, 2};

        System.out.println("House values: " + Arrays.toString(test1) + " -> Max Robbed: " + solver.rob(test1));
        System.out.println("House values: " + Arrays.toString(test2) + " -> Max Robbed: " + solver.rob(test2));
        System.out.println("House values: " + Arrays.toString(test3) + " -> Max Robbed: " + solver.rob(test3));
    }
}
