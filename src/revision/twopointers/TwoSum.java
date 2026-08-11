package revision.twopointers;

import java.util.*;

public class TwoSum {

    public int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // optimized
    public int[] twoSumOptimized(int[] nums, int target) {

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

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>(new ArrayList<>());
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n; ) {
                int p = j + 1;
                int q = n - 1;

                while (p < q) {
                   long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];

                   if(sum > target){
                       q--;
                   } else if(sum < target){
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

                       while ( p < q && nums[p] == nums[p-1]){
                           p++;
                       }
                   }
                }
                j++;
                while (j<n && nums[j] == nums[j-1]){
                    j++;
                }
            }
        }
        return ans;
    }

}
