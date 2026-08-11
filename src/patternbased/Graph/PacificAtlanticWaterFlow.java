package patternbased.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    int[][] directions = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights){
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific
        //Left column
        for(int c=0; c < cols; c++){
            dfs(0,c,heights,pacific);
        }
        for(int r=0; r < rows; r++){
            dfs(r,0,heights,pacific);
        }

        // Atlantic
        for(int c=0; c< cols; c++){
            dfs(rows-1,c,heights,atlantic);
        }

        for (int r=0; r< rows; r++){
            dfs(r,cols-1,heights,atlantic);
        }

        List<List<Integer>> answer = new ArrayList<>();

        for(int r = 0 ; r < rows; r++){
            for(int c=0 ; c< cols; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    answer.add(Arrays.asList(r,c));
                }
            }
        }

        return answer;

    }

    private  void dfs(int r, int c, int[][] heights, boolean[][] visited){
        if(visited[r][c]){
            return;
        }

        visited[r][c] = true;

        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && !visited[nr][nc] &&
            heights[nr][nc] >= heights[r][c]){
                dfs(nr,nc,heights,visited);
            }
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow solver = new PacificAtlanticWaterFlow();

        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<List<Integer>> result = solver.pacificAtlantic(heights);

        System.out.println("Grid Heights:");
        for (int[] row : heights) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nCells [row, col] that can flow to both oceans:");
        System.out.println(result);
    }
}
