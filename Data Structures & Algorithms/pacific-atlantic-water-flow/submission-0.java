class Solution {
    private int[][] directions = {
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };
    private int ROWS;
    private int COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        Set<Pair<Integer,Integer>> pacificSet = new HashSet<>();
        Set<Pair<Integer,Integer>> atlanticSet = new HashSet<>();
        for (int i=0;i<COLS; i++) {
            dfs(0, i, heights[0][i], pacificSet, heights);
            dfs(ROWS-1, i, heights[ROWS-1][i], atlanticSet, heights);
        }
        for (int k=0;k<ROWS;k++) {
            dfs(k, 0, heights[k][0], pacificSet, heights);
            dfs(k, COLS-1, heights[k][COLS-1], atlanticSet, heights);       
        }
        List<List<Integer>> result = new ArrayList<>();
        for ( int r = 0; r<ROWS; r++) {
            for ( int c = 0; c<COLS; c++) {
                if (pacificSet.contains(new Pair<>(r,c))
                    && atlanticSet.contains(new Pair<>(r,c))) {
                        result.add(new ArrayList<>(
                            Arrays.asList(r,c)
                        ));
                    }
            }
        }

        return result;
    }

    private void dfs(int r, int c, int prevHeight, Set<Pair<Integer,Integer>> set, int[][] heights) {
        set.add(new Pair<>(r,c));
        for (int[] dir: directions) {
            int row = r + dir[0];
            int col = c + dir[1];
            if (row >=0 && col >=0 && row <ROWS && col < COLS
                && heights[row][col] >= prevHeight && 
                !set.contains(new Pair<>(row, col))) {
                    dfs(row, col, heights[row][col], set, heights);
                }

        }
    }
}
