package patternbased.dynamicprogramming;

public class HouseRobber2 {
   public int rob(int[] nums){
       int n = nums.length;
       // base case
       if(n==1){
           return nums[0];
       }

       return Math.max(robRange(nums,0,n-1),robRange(nums,1,n-2));
   }

   public int robRange(int[] nums, int start, int end){

       int next1 = 0;
       int next2 = 0;

       for(int i = end; i >= start ; i--){
           int current = Math.max(nums[i] + next2, next1);
           next2 = next1;
           next1 = current;
       }

       return next1;
   }
}
