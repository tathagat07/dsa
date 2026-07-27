package revision;

import java.util.Arrays;

public class RotateArray {


    public void rotate(int[] nums, int k){
        int n = nums.length;
        k = k % n ;

        reverse(nums,0, n-1);
        reverse(nums,0,k-1);
        reverse(nums, k,n-1);

    }

    public void reverse(int[] nums, int start, int end){

        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }


    public void rotateRevision(int[] nums, int k){
        int n = nums.length;
        k = k % n;

        reverseRevision(nums, 0 , n-1);
        reverseRevision(nums, 0 , k-1);
        reverseRevision(nums, k, n -1);
    }

    public void reverseRevision(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start ++;
            end --;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};

        RotateArray rotateArray = new RotateArray();
        System.out.println("Original Array: " + Arrays.toString(nums));
        rotateArray.rotateRevision(nums,2);
        System.out.println("Rotated Array: " + Arrays.toString(nums));
    }
}
