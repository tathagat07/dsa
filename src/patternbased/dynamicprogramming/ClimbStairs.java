package patternbased.dynamicprogramming;

import java.util.Arrays;

public class ClimbStairs {

    public int climbStairsMemo(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return climb(n, dp);
    }

    private int climb(int n, int[] dp) {

        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        if (dp[n] != -1)
            return dp[n];

        dp[n] = climb(n - 1, dp) + climb(n - 2, dp);

        return dp[n];
    }

    // Complete Tabulation Solution
    public int climbStairsTabulation(int n) {

        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int prev2 = 0;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int current = prev2 + prev1;

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int current = prev2 + prev1;

            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];

        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            dp[i] = dp[i + 1];

            if (i + 1 < n) {
                int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');

                if (num <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        ClimbStairs solver = new ClimbStairs();

        int[] testCases = {1, 2, 3, 4, 5, 10};

        System.out.println("n = 6 :" + solver.fib(6));

        for (int n : testCases) {
            System.out.println("Stairs (n = " + n + "): " + solver.climbStairs(n) + " distinct ways");
        }
    }
}
