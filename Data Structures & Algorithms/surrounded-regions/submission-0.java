class Solution {
    private int ROWS;
    private int COLS;
    private int[][] directions = {
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        for (int i = 0; i< ROWS; i++) {
            for (int j = 0; j<COLS; j++) {
                if (i == 0 || i == ROWS - 1 || j == 0 || j == COLS-1) {
                    dfs(i, j, board);
                }
            }
        }
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {
        if (row>=0 && col >=0 && row<ROWS && col<COLS
            && board[row][col] == 'O') {
                board[row][col] = 'T';
                for (int[] dir: directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    dfs(nr,nc, board);
                }
            }

            return;
    }
}
