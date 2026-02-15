package dev.hashing;

import java.util.*;

public class MaxSubArray {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public  void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // 1st step : find pivot
        for(int i = n-2 ; i>=0; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }

            if(pivot == -1){
                reverse(nums, 0, n - 1);
                return;
            }
        }

        // second step : next larger element
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }

        // 3rd step : reverse pivot
            reverse(nums, pivot + 1, n - 1);

    }

    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int[] lmax = new int[n];
        int[] rmax = new int[n];

        lmax[0] = height[0];
        rmax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);

        }
        for (int j = n - 2; j >= 0; j--) {
            rmax[j] = Math.max(rmax[j + 1], height[j]);

        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return ans;

    }

    public int trap2Pointer(int[] height) {
        int n = height.length;
        int l_max = 0;
        int r_max = 0;
        int l = 0;
        int r = n - 1;
        int ans = 0;

        while (l < r) {
            l_max = Math.max(l_max, height[l]);
            r_max = Math.max(r_max, height[r]);

            if (l_max < r_max) {
                ans += l_max - height[l];
                l++;
            } else {
                ans += r_max - height[r];
                r--;
            }

        }
        return ans;

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0;
        // Add all elements to heap
        for (int num : nums) {
            maxHeap.add(num);
        }

        for (int i = 0; i < k; i++) {
            ans = maxHeap.poll();
        }


        return ans;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for(int j = i+1; j< n; ) {

                int p = j + 1;
                int q = n - 1;

                while(p < q) {
                    long sum = nums[i] + nums[j] + nums[p] + nums[q];

                    if(sum > target){
                        q--;
                    } else if (sum < target) {
                        p++;
                    } else  {
                        List<Integer> ans1 = new ArrayList<>();
                        ans1.add(nums[i]);
                        ans1.add(nums[j]);
                        ans1.add(nums[p]);
                        ans1.add(nums[q]);

                        ans.add(ans1);
                        p++;
                        q--;

                        while(p<q && nums[p] == nums[p-1]) p++;
                    }


                }
                j++;
                while(j<n && nums[j] == nums[j-1]) j++;

            }
        }

        return ans;

    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>(new ArrayList<>());


        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> ans1 = new ArrayList<>();
                    ans1.add(nums[i]);
                    ans1.add(nums[j]);
                    ans1.add(nums[k]);
                    ans.add(ans1);
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return ans;
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                result[0] = index;
                result[1] = i;
                break;
            } else {
                map.put((target - nums[i]), i);
            }
        }
        return result;
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }


    public static int singleSum(int nums[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        TreeMap<Integer, Integer> revMap = new TreeMap<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            revMap.put((Integer) entry.getValue(), (Integer) entry.getKey());
        }

        return revMap.firstEntry().getValue();

    }

    // Kedane's Algorithm
    public static int maxSum(int nums[]) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        int currSum = 0;

        for (int i = 0; i < n; i++) {

            currSum += nums[i];
            maxSum = Math.max(currSum, maxSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);
        int k =0;

        for(int i=0; i< m;i++){
            minHeap.add(nums1[i]);
        }

        for(int j = 0; j< n ; j++){
            minHeap.add(nums2[j]);
        }

        while(!minHeap.isEmpty()){
            nums1[k++] = minHeap.poll();
        }

    }


    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int arr1[] = {4, 1, 2, 1, 2};
//        int maxSum = Integer.MIN_VALUE;
//        int n = arr.length;
//        for(int st = 0; st < n ; st ++ ){
//            int currSum = 0;
//
//            for (int end = st; end < n ; end ++){
//                currSum+= arr[end];
//                maxSum = Math.max(currSum, maxSum);
//            }
//
//        }
//        int maxSum = maxSum(arr);
//        System.out.println(maxSum);

        int ans = singleSum(arr1);
        System.out.println(ans);

    }


}
