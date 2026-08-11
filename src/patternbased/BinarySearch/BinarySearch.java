package patternbased.BinarySearch;

public class BinarySearch {

    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid]== target){
                return mid;
            }

            // Left half is sorted
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            // right half is sorted
            else {
                  if(target > nums[mid] && target <= nums[right]){
                      left = mid + 1;
                  } else {
                      right = mid - 1;
                  }
            }
        }

      return -1;
    }

    public int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left ) / 2;

            if(nums[mid] > nums[right] ){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }


    public int shipWithinDays(int[] weights, int days){
        int left = 0;
        int right = weights.length - 1;

        for(int weight : weights){
            left = Math.max(left,weight);
            right += weight;
        }

        while (left < right){
            int mid = left + (right - left)/2;

            if(canShip(weights,days,mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
     return left;
    }

    private boolean canShip(int[] weights, int days, int capacity){
        int usedDays = 1;
        int currentLoad = 0;

        for(int weight : weights){
            if(currentLoad + weight > capacity){
                usedDays ++;
                currentLoad = 0;
            }

            currentLoad += weight;
        }

        return usedDays <= days;
    }

    public int splitArray(int[] nums, int k){
        int left = 0;
        int right = nums.length - 1;

        for(int num : nums){
            left = Math.max(left,num);
            right += num;
        }

        while(left < right){
            int mid = left + (right - left) /2;
            if(canSplit(nums,k,mid)){
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    private boolean canSplit(int[] nums, int k , int maxSum){
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




    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int[] nums = {4,5,6,7,0,1,2};
        int min = binarySearch.findMin(nums);
        System.out.println(min);
    }
}
