class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int islands = 0;
        for (int r = 0; r<ROWS;r++) {
            for (int c = 0; c<COLS; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        grid[r][c] = '0';
        queue.add(new int[]{r,c});
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] dir: directions) {
                int row = node[0] + dir[0];
                int col = node[1] + dir[1];
                if (row>=0 && col >= 0 && row<grid.length && col<grid[0].length && grid[row][col] == '1') {
                        queue.add(new int[]{row, col});
                        grid[row][col] = '0';
                    }
            }
        }
    }
}
