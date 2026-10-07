class Solution {
    private int ROWS;
    private int COLS;
    private int[][] directions = {
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int r = 0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                else if (grid[r][c] == 2) {
                    queue.add(new int[]{
                        r,c
                    });
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int range = queue.size();
            for (int i = 0; i<range; i++) {
                int[] rot = queue.poll();
                for (int[] direction: directions) {
                    int row = rot[0] + direction[0];
                    int col = rot[1] + direction[1];

                    if (row>=0 && col>=0 && row < ROWS && 
                        col < COLS && grid[row][col] == 1 ) {
                            queue.add(new int[]{row, col});
                            grid[row][col] = 2;
                            fresh--;
                        }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
