
class Solution {
    // A map to store results of subproblems: key = "i,total", value = number of ways
    private Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dfs(0, 0, nums, target);
    }

    private int dfs(int i, int total, int[] nums, int target) {
        // Base case: reached the end of the array
        if (i == nums.length) {
            return target == total ? 1 : 0;
        }

        // Create a unique key for the current state
        String key = i + "," + total;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Calculate both branches: addition and subtraction
        int add = dfs(i + 1, total + nums[i], nums, target);
        int subtract = dfs(i + 1, total - nums[i], nums, target);

        // Store the result in the map and return
        memo.put(key, add + subtract);
        return memo.get(key);
    }
}