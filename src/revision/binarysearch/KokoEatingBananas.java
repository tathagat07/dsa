package revision.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h){
        // minimum possible speed
        int left = 1;
        // max possible speed : largest pile
        int right = 0;
        for(int pile : piles){
            right = Math.max(right,pile);
        }

        while (left < right){
            int mid = left + (right - left) /2;

            if(canFinish(piles,h,mid)){
                // Mid could be the answer, so keep it
                right = mid;
            } else {
                // Mid cannot be the answer
                left = mid +1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0;

        for (int pile : piles){
            // ceil (pile/speed)
            hours += (pile + speed - 1) / speed;

            if (hours > h){
                return false;
            }
        }
        return true;
    }

    // 2. Capacity To Ship Packages Within D Days
   public int shipWithinDays(int[] weights, int days){
        int left = 0;
        int right = 0;

        for (int weight : weights){
            left = Math.max(left,weight);
            right += weight;
        }

        while (left < right){
            int mid = left + (right - left) /2;

            if(canShip(weights,days,mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
   }

    private boolean canShip(int[] weights, int days, int capacity) {
        int usedDays = 1;
        int currentLoad = 0;

        for (int load : weights){
            if (currentLoad + load > capacity){
                usedDays++;
                currentLoad = 0;
            }

            currentLoad += load;
        }

        return usedDays <= days;
    }

    // 3. Split Array Largest Sum
    public int splitArray(int[] nums, int k){
        int left = 0;
        int right = 0;

        for(int num : nums){
            left = Math.max(left,num);
            right += num;
        }

        while (left < right){
            int mid = left + (right - left) / 2;

            if(canSplit(nums,k,mid)){
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

        for (int num : nums){
            if (sum + num > maxSum){
                count++;
                sum = 0;
            }
        }
        return count <=k;
    }

    //5. Aggressive Cows
    public int aggressiveCows(int[] stalls, int cows){
        Arrays.sort(stalls);
        int left = 1;
        int right = stalls[stalls.length -1] - stalls[0];

        while (left < right){
            int mid = left + (right - left) /2;

            if(canPlace(stalls,cows,mid)){
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canPlace(int[] stalls, int cows, int distance) {
        int placed = 1;
        int last = stalls[0];

        for (int i = 1; i < stalls.length ; i++){
            if (stalls[i] - last < distance){
                placed++;
                last = stalls[i];
            }
        }
        return placed >= cows;
    }

    // 6. Allocate Books
  public int allocateBooks(int[] books, int students){
        if (students > books.length){
            return -1;
        }
        int left = 0;
        int right = 0;

        for (int book : books){
            left = Math.max(left,book);
            right += book;
        }

        while (left < right){
            int mid = left + (right - left) /2;
            if (canAllocate(books,students,mid)){
                right = mid;
            } else{
                left = mid + 1;
            }

        }
     return left;
  }

    private boolean canAllocate(int[] books, int students, int maxPages) {
        int studentCount = 1;
        int currentPages = 0;

        for (int page : books){
            if (currentPages + page > maxPages){
                studentCount++;
                currentPages = 0;
            }

            currentPages += page;
        }

        return studentCount <= students;
    }

    //7. Painters' problem
    public int paint(int[] boards, int painters){
        int left = 0;
        int right = 0;

        for (int board : boards){
            left = Math.max(left,board);
            right += board;
        }

        while (left < right){
            int mid = left + (right - left) / 2;
            if(canPaint(boards,painters,mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

    private boolean canPaint(int[] boards, int painters, int maxWork) {
        int paintersCount = 1;
        int currentWork = 0;

        for (int board : boards){
            if (currentWork + board > maxWork){
                paintersCount++;
                currentWork = 0;
            }
            currentWork+=board;
        }
        return paintersCount <= painters ;
    }

    // 4. Minimum Days to Make m Bouquets


    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println(kokoEatingBananas.minEatingSpeed(piles, h)); // Output: 4
    }
}
