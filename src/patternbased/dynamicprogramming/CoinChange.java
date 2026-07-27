package patternbased.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    private int solve(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int answer = 1_000_000_000;

        for (int coin : coins) {
            answer = Math.min(answer, 1 + solve(coins, amount - coin));
        }

        return answer;
    }

    // Complete Memoized Solution
    private int solveMemoized(int[] coins,
                              int amount,
                              int[] dp) {
        int INF = Integer.MAX_VALUE;

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return INF;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int answer = INF;

        for (int coin : coins) {
            int result = solveMemoized(coins, amount - coin, dp);

            if (result != INF) {
                answer = Math.min(answer, result + 1);

            }

            dp[amount] = answer;

        }
        return dp[amount];
    }
    //Complete Bottom-Up Solution

    public int coinChange(int[] coins, int amount) {
        int INF = amount + 1;

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];

    }

}
