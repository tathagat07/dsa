package revision;

import java.util.Arrays;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // left half sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // right half sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public int allocateBooks(int[] books, int students) {
        if (students > books.length) {
            return -1;
        }

        int left = 0;
        int right = 0;

        for (int pages : books) {
            left = Math.max(left, pages);
            right += pages;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canAllocate(books, students, mid)) {
                right = mid;
            } else {
                left = mid - 1;
            }
        }
        return left;
    }

    private boolean canAllocate(int[] books, int students, int maxPages) {
        int studentCount = 1;
        int currentPages = 0;

        for (int pages : books) {
            if (currentPages + pages > maxPages) {
                studentCount++;
                currentPages = 0;
            }

            currentPages += pages;
        }

        return studentCount <= students;
    }

    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(num, left);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int sum = 0;

        for(int num : nums){
            if(sum + num > maxSum){
                count++;
                sum = 0;
            }
            sum += num;
        }
        return count <= k;
    }

    // aggressive cows
    public int aggressiveCows(int[] stalls, int cows){
        Arrays.sort(stalls);

        int n = stalls.length;
        int left = 1;
        int right = stalls[n-1] - stalls[left];

        while (left < right){
            int mid = left + (right - left) /2;

            if(canPlace(stalls,cows,mid)){
                left = mid;
            } else {
                right = mid -1;
            }
        }
        return left;
    }

    private boolean canPlace(int[] stalls, int cows, int distance) {
        int placed = 1;
        int last = stalls[0];

        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - last > distance){
                placed++;
                last = stalls[i];
            }
        }
        return placed >= cows;
    }


}
