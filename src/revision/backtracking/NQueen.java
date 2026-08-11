package revision.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    List<List<String>> answer = new ArrayList<>();

    char[][] board;
    int n;

    public List<List<String>> solveQueens(int n){
        this.n = n;
        board = new char[n][n];

        for (int i = 0 ; i < n ; i++){
            Arrays.fill(board[i],'.');
        }

        dfs(0);

        return answer;
    }

    private void dfs(int row) {

        // All queen placed
        if(row == n){
            saveBoard();
            return;
        }

        // try every row
        for(int col = 0 ; col < n ; col++){
            if(isSafe(row,col)){
                // choose
                board[row][col] = 'Q';

                // explore
                dfs(row + 1);

                // undo
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col) {

        // same columns
        for(int r = 0 ; r < row ; r++){
            if(board[r][col]== 'Q'){
                return false;
            }
        }

        // Upper-left diagonal
        for(int r = row -1 , c = col -1 ; r>=0 && c>= 0 ; r--,c--){
            if(board[r][col]== 'Q'){
                return false;
            }
        }

        // upper right diagonal

        for(int r = row -1 , c = col + 1; r>= 0 && c< col;r--,c++){
            if(board[r][col]== 'Q'){
                return false;
            }
        }

        return true;
    }

    private void saveBoard() {
        List<String > solution = new ArrayList<>();

        for(char[] row : board){
            solution.add(new String(row));
        }
        answer.add(solution);
    }
}
