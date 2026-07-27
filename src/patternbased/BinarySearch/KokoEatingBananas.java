package patternbased.BinarySearch;

public class KokoEatingBananas {
    // BINARY SEARCH
    public int minEatingSpeed(int[] piles, int h) {
        // Minimum possible speed
        int left = 1;
        // Maximum possible speed = largest pile
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                // Mid could be the answer, so keep it
                right = mid;
            } else {
                // Mid cannot be the answer
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;

            if (hours > h) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        KokoEatingBananas obj = new KokoEatingBananas();

        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println(obj.minEatingSpeed(piles, h));
    }
}
