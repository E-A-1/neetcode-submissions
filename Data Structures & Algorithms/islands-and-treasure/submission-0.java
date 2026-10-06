class Solution {
    private int[][] directions = {
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };
    private int ROWS,COLS;
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        Set<Pair<Integer,Integer>> visited = new HashSet<>();
        for (int i=0; i<ROWS;i++) {
            for (int j=0;j<COLS;j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i,j});
                    visited.add(new Pair<>(i,j));
                }
            }
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // Snapshot current layer size

            for (int i = 0; i < size; i++) {
                int[] item = queue.poll();
                grid[item[0]][item[1]] = step; // Assign current distance layer

                for (int[] direction : directions) {
                    int row = item[0] + direction[0];
                    int col = item[1] + direction[1];

                    if (row < 0 || col < 0 || row >= ROWS || col >= COLS
                        || grid[row][col] == -1 || visited.contains(new Pair<>(row, col))) {
                        continue;
                    }

                    visited.add(new Pair<>(row, col));
                    queue.add(new int[]{row, col});
                }
            }
            step++; // Increment distance only after processing the ENTIRE current level
        }
    }
}
