package patternbased.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;

        for(int r = 0; r < rows; r++){
            for (int c = 0; c < cols ; c++){
                if(grid[r][c] == 1 && !visited[r][c]){
                    int area = bfs(grid,visited,r,c);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
    return maxArea;
    }

    private int bfs(int[][] grid, boolean[][] visited, int row, int col){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row,col});
        visited[row][col] = true;

        int area = 1;
        int[][] directions = {
                {-1,0},
                {1,0},
                {0,-1},
                {0,1}
        };

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >=0 && nr < grid.length &&
                        nc >= 0 && nc <grid[0].length
                        && grid[nr][nc] ==1 &&!visited[nr][nc] ){

                    visited[nr][nc] = true;
                    area++;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        MaxAreaOfIslands solver = new MaxAreaOfIslands();

        int[][] grid = {
                {0, 0, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1}
        };

        System.out.println("Grid Matrix:");
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        int result = solver.maxAreaOfIsland(grid);
        System.out.println("\nMax Area of Island: " + result);
    }

}
