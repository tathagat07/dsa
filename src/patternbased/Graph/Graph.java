package patternbased.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    // Flood fill
    public int[][] floodFill(int[][] image,
                             int sr,
                             int sc,
                             int newColor) {

        int originalColor = image[sr][sc];

        if (originalColor == newColor) {
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        image[sr][sc] = newColor;

        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < image.length && nc >= 0
                        && nc < image[0].length &&
                        image[nr][nc] == originalColor) {

                    image[nr][nc] = newColor;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return image;
    }


    // Rotten Oranges
    public int orangesRotting(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        int minutes = 0;

        // Initial scan
        for(int r=0; r < rows ; r++){
            for (int c=0; c< cols; c++){
                if(grid[r][c] == 2){
                    queue.offer(new int[]{r,c});
                }

                if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }

        //No Fresh oranges
        if(fresh == 0){
            return 0;
        }

        int[][] directions = {
                {-1,0},
                {1,0},
                {0,-1},
                {0,1}
        };

        while (!queue.isEmpty() && fresh > 0){
            int size = queue.size();

            for(int i = 0 ; i < size; i++){
                int[] current = queue.poll();

                int r = current[0];
                int c = current[1];

                for(int[] dir : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if( nr >=0 && nr < rows && nc >=0 && nc < cols && grid[nr][nc]== 1){

                        grid[nr][nc] =2;
                        fresh--;

                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }





        return fresh == 0 ? minutes : -1;
    }


    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int isLands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    isLands++;
                    bfs(grid, visited, r, c);
                }
            }
        }

        return isLands;
    }

    private void bfs(char[][] grid,
                     boolean[][] visited,
                     int row,
                     int col) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < grid.length && nc >= 0
                        && nc < grid[0].length && grid[nr][nc] == '1'
                        && !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // --- Test 1: Flood Fill ---
        System.out.println("=== 1. FLOOD FILL ===");
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        System.out.println("Original Image:");
        for (int[] row : image) System.out.println(Arrays.toString(row));

        int[][] filledImage = graph.floodFill(image, 1, 1, 2);
        System.out.println("After Flood Fill (sr=1, sc=1, newColor=2):");
        for (int[] row : filledImage) System.out.println(Arrays.toString(row));


        // --- Test 2: Rotten Oranges ---
        System.out.println("\n=== 2. ROTTEN ORANGES ===");
        int[][] orangesGrid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("Initial Orange Grid (2=rotten, 1=fresh, 0=empty):");
        for (int[] row : orangesGrid) System.out.println(Arrays.toString(row));

        int minutes = graph.orangesRotting(orangesGrid);
        System.out.println("Minutes until all fresh oranges rot: " + minutes);


        // --- Test 3: Number of Islands ---
        System.out.println("\n=== 3. NUMBER OF ISLANDS ===");
        char[][] islandGrid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Island Grid ('1'=land, '0'=water):");
        for (char[] row : islandGrid) System.out.println(Arrays.toString(row));

        int totalIslands = graph.numIslands(islandGrid);
        System.out.println("Total Islands found: " + totalIslands);
    }
}
