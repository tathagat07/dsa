package patternbased.BinarySearch;

public class MinimumDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        // Impossible case
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int bloom : bloomDay) {
            left = Math.min(left, bloom);
            right = Math.max(right, bloom);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int currentDay) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= currentDay) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
