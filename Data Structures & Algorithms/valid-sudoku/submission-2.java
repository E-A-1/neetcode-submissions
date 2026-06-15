class Solution {
    public boolean isValidSudoku(char[][] board) {
        // The best one: BitMap one
        int row[] = new int[9];
        int col[] = new int[9];
        int square[] = new int[9];
        for (int r = 0; r<9; r++) {
            for (int c=0; c<9; c++) {
                if (board[r][c] == '.') continue;
                int value = board[r][c] - '1';

if (((row[r] & (1 << value)) > 0) ||
    ((col[c] & (1 << value)) > 0) ||
    ((square[(r / 3) * 3 + c / 3] & (1 << value)) > 0)
) {
    return false;
}
                row[r] |= (1 << value);
                col[c] |=  (1 << value);
                square[(r/3)*3+c/3] |= (1 << value);
            }
        }
        return true;
    }
}
