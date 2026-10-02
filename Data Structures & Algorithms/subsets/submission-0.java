class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0, result, subset, nums);
        return result;
    }

    private void dfs(int i, List<List<Integer>> result, List<Integer> subset, int[] nums) {
        if (i>=nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i+1, result, subset, nums);
        subset.remove(subset.size()-1);
        dfs(i+1, result, subset, nums);
    }
}
