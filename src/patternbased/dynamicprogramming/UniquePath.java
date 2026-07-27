package patternbased.dynamicprogramming;

import java.util.Arrays;

public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, m, n, dp);
    }

    private int solve(int row,
                      int col,
                      int m,
                      int n,
                      int[][] dp) {

        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (row == m || col == n) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = solve(row + 1, col, m, n, dp) + solve(row, col + 1, m, n, dp);

        return dp[row][col];
    }

    // Complete Bottom-Up Solution
    public int uniquePathsOptimized(int m, int n) {

        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = 1;

        for (int row = m - 1; row >= 0; row--) {

            for (int col = n - 1; col >= 0; col--) {

                if (row == m - 1 && col == n - 1) {
                    continue;
                }

                int down = (row == m - 1) ? 0 : dp[row + 1][col];

                int right = (col == n - 1) ? 0 : dp[row][col + 1];

                dp[row][col] = down + right;
            }
        }

        return dp[0][0];
    }
}
