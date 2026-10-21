class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
int[][] memo = new int[coins.length + 1][amount + 1];
for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(coins, 0, amount, memo);

    }

    private int dfs(int[] coins, int i, int a, int[][] memo) {
        if (a == 0) {
            return 1;
        }
        if (i >= coins.length) {
            return 0;
        }
// Return cached result if already computed
        if (memo[i][a] != -1) return memo[i][a];
        int res = 0;

        if (a>=coins[i]) {
            res = dfs(coins, i+1, a, memo);
            res+=dfs(coins, i, a-coins[i], memo);
        }
// Store the result in memo before returning
        memo[i][a] = res;
        return res;
    }
}
