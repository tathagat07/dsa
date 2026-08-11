package revision.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlowRev {
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

        // for pacific
        for(int r = 0 ; r < rows; r++){
             dfs(r,0,heights,pacific);
        }

        for(int c = 0 ; c< cols; c++){
            dfs(0,c,heights,pacific);
        }

        // for Altantic

        for(int c = 0 ; c< cols; c++){
            dfs(rows - 1,c ,heights, atlantic);
        }

        for(int r = 0; r < rows; r++){
            dfs(r,cols-1,heights,atlantic);
        }

        List<List<Integer>> answer = new ArrayList<>();

        for(int r = 0 ; r < rows; r++){
            for (int c = 0 ; c< cols; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    answer.add(Arrays.asList(r,c));
                }
            }
        }

        return answer;
    }

    private void dfs(int r, int c , int[][] heights, boolean[][] visited){
        if (visited[r][c]){
            return;
        }

        visited[r][c] = true;

        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr>= 0 && nr < heights.length&&
            nc >= 0 && nc < heights[0].length && !visited[nr][nc]
            && heights[nr][nc] >= heights[r][c]){

                dfs(nr,nc,heights,visited);
            }
        }
    }
}
