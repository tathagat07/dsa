package patternbased.BinarySearch;

import java.util.Arrays;

public class AggresiveCows {

    public int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int left = 1;
        int right = stalls[n-1] - stalls[0];

        while (left < right) {
            int mid = left + (right - left + 1 ) / 2;

            if (canPlace(stalls, cows, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean canPlace(int[] stalls, int cows, int distance){

        int placed = 1;
        int last = stalls[0];

        for(int i = 1; i < stalls.length ; i++){

            if((stalls[i] - last) >= distance ){
                placed ++;
                last = stalls[i];
            }
        }

        return placed >= cows;
    }

    public static void main(String[] args) {
        AggresiveCows aggresiveCows = new AggresiveCows();
        int[] arr = {1,2,4,8,9};
        int k = 3;
        int result = aggresiveCows.aggressiveCows(arr,k);
        System.out.println(result);
    }
}
