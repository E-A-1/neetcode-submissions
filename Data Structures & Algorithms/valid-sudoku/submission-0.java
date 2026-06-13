class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Brute force solution
        for (int row=0;row<9;row++) {
            Set<Character> seen = new HashSet<>();
            for (int j=0;j<9;j++) {
                if (board[row][j] == '.') continue;
                if(seen.contains(board[row][j])) return false;
                seen.add(board[row][j]);
            }
        }
        for (int column=0;column<9;column++) {
            Set<Character> seen = new HashSet<>();
            for (int j=0;j<9;j++) {
                if (board[j][column] == '.') continue;
                if(seen.contains(board[j][column])) return false;
                seen.add(board[j][column]);
            }
        }
        for (int square = 0; square<9;square++) {
            Set<Character> seen = new HashSet<>();
            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) {
                    int row = (square/3) * 3 + i;
                    int column = (square%3) * 3 + j;
                    if (board[row][column]== '.') continue;
                    if (seen.contains(board[row][column])) return false;
                    seen.add(board[row][column]);
                }
            }
        }

        return true;
    }
}
