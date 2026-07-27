package patternbased.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

    List<List<String >> answer = new ArrayList<>();
    char[][] board;
    int n;

    public List<List<String>> solveNQueen(int n){
        this.n = n;
        board = new char[n][n];

        for (int i = 0; i < n; i++){
            Arrays.fill(board,'.');
        }

        dfs(0);

        return answer;
    }

    private void dfs(int row) {
        // All queens placed
        if(row == n){
            saveBoard();
            return;
        }

        // Try every column
        for(int col = 0 ; col < n ; col++){
            if(isSafe(row,col)){
                //Choose
                board[row][col] = 'Q';
                // Explore
                dfs(row + 1);
                // Undo
                board[row][col] = '.';

            }
        }
    }

    private boolean isSafe(int row, int col) {
        // same column

        for(int r=0 ; r < row; r++){
            if(board[r][col] == 'Q'){
                return false;
            }
        }

        // upper left diagonal
        for(int r = row -1, c = col -1; r>=0 && c>=0; r--,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // upper right diagonal
        for(int r = row -1, c = col +1; r>=0 && c>=0; r--,c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;
    }

    private void saveBoard() {
        List<String> solution = new ArrayList<>();

        for(char[] row : board){
            solution.add(new String(row));
        }
        answer.add(solution);
    }

}
