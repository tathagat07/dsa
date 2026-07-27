package patternbased.TwoPointers;

public class ContainerWithMostWater {

/*    The Algorithm
     Start with the widest container.
    Compute the current area.
    Update the maximum.
    Move the shorter pointer.
    Repeat until the pointers meet. */

    // TWO POINTER
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n - 1;

        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentArea = Math.min(heights[left], heights[right]) * width;

            maxArea = Math.max(currentArea, maxArea);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
