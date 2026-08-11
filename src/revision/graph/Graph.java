package revision.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    public int numIsland(char[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        int islands = 0;

        for(int r = 0 ; r < row ; r++){
            for(int c = 0 ; c < col ; c++){

                if(grid[r][c] == '1' && !visited[r][c]){
                    islands++;
                    bfs(grid,visited,r,c);
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {row,col});

        visited[row][col] = true;

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

            for (int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >=0 && nr < grid.length
                        && nc >=0 && nc < grid[0].length
                        && grid[nr][nc] =='1' && !visited[nr][nc]){

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        int maxArea = 0;

        for(int r = 0 ; r < row ; r++){
            for (int c = 0 ; c < col ; c++){

                if(grid[r][c] == 1 && !visited[r][c]){
                    int area = bfsMaxArea(grid,visited,r,c);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }

    private int bfsMaxArea(int[][] grid, boolean[][] visited, int row, int col) {
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

                if(nr>=0 && nr < grid.length&&
                nc >=0 && nc< grid[0].length && grid[nr][nc] ==1 && !visited[nr][nc]){

                    visited[nr][nc] = true;
                    area++;
                    queue.offer(new int[]{nr,nc});
                }

            }
        }
        return area;
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        int originalColor = image[sr][sc];

        if(originalColor == newColor){
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr,sc});
        image[sr][sc] = newColor;


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

                if(nr >= 0 && nr < image.length &&
                    nc >= 0 && nc < image[0].length &&
                    image[nr][nc] == originalColor  ){

                    image[nr][nc] = newColor;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return image;
    }

}
