class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        dfs(0, result, subset, nums);
        return new ArrayList<>(result);
    }

    private void dfs(int i, Set<List<Integer>> result, List<Integer> subset, int[] nums) {
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
