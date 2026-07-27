package patternbased.dynamicprogramming;

public class MinimumPathSum {
    //Complete Memoized Solution
    private int solve(int row,
                      int col,
                      int[][] grid,
                      int[][] dp){
        int INF = Integer.MAX_VALUE;

        if(row == grid.length -1 &&
            col == grid[0].length - 1){
            return grid[row][col];
        }

        if(row == grid.length -1 ||
                col == grid[0].length - 1){
            return INF;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        dp[row][col] = grid[row][col] + Math.min(solve(row + 1,col, grid,dp), solve(row,col + 1, grid, dp));

        return dp[row][col];
    }

    // Complete Bottom-Up Solution
    public int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        int INF = 1_000_000_000;

        int[][] dp = new int[m][n];

        dp[m-1][n-1] = grid[m-1][n-1];

        for (int row = m-1; row>=0; row--){
            for (int col = n-1; col >=0; col--){

                if(row == m-1 && col == n-1){
                    continue;
                }

                int down = row == m-1 ? INF : dp[row + 1][col];

                int right = col == n-1 ? INF : dp[row][col -1];

                dp[row][col] = grid[row][col] + Math.min(down,right);
            }
        }

        return dp[0][0];
    }
}
