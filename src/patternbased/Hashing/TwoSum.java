package patternbased.Hashing;

import java.util.*;

public class TwoSum {
    public int[] twoSumBrute(int[] nums, int target) {
        //O(n^2)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    //O(1)
    public int[] twoSumHashing(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] nums2 = {3, 2, 4};
        int target2 = 6;

        int[] nums3 = {3, 3};
        int target3 = 6;

        System.out.println("Array: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Indices: " + Arrays.toString(solver.twoSumHashing(nums1, target1)));

        System.out.println("\nArray: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Indices: " + Arrays.toString(solver.twoSumHashing(nums2, target2)));

        System.out.println("\nArray: " + Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("Indices: " + Arrays.toString(solver.twoSumHashing(nums3, target3)));
    }
}
