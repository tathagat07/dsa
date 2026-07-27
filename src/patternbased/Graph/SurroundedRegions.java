package patternbased.Graph;

public class SurroundedRegions {

    public void solve(char[][] board){
        int rows = board.length;
        int cols = board[0].length;

        // TOP & Bottom
        for(int c = 0 ; c < cols ; c++){
            dfs(board,0,c);
            dfs(board,rows -1,c);
        }

        // Left and Right rows
        for(int r = 0; r < rows; r++){
            dfs(board,r,0);
            dfs(board,r,cols - 1);
        }

        // Flip cells
        for(int r = 0 ; r < rows ; r++){
            for (int c = 0 ; c < cols ; c++){
                if(board[r][c] == 'T'){
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }
    }


    private void dfs(char[][] board, int r, int c){
        if(r <0 || r >=board.length || c < 0 || c >board[0].length || board[r][c] !='O'){
            return;
        }
        board[r][c] = 'T';
        dfs(board,r-1, c);
        dfs(board,r+1, c);
        dfs(board,r, c-1);
        dfs(board,r, c+1);

    }
}
