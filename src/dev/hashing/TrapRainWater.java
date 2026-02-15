package dev.hashing;

public class TrapRainWater {

    public int maxArea(int[] height) {
        int maxWater = 0;
        int n = height.length;

        int left = 0;
        int right = n-1;

        while (left <right){
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater,width * minHeight);

            if(height[left] < height[right]){
                left ++;
            } else {
                right--;
            }

        }
        return maxWater;
    }

    public static void main(String[] args) {
        TrapRainWater sol = new TrapRainWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7}; // Input array
        int result = sol.maxArea(height); // Call function
        System.out.println("Maximum water that can be stored: " + result);
    }
}
