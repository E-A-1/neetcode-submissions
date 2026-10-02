class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>  current = new ArrayList<>();
        dfs(0, result, current, 0, target, nums);
        return result;
    }

    private void dfs(int i, List<List<Integer>> result,List<Integer>  current, int total, int target, int[] nums ) {
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (i >= nums.length || total>target) {
            return;
        }

        current.add(nums[i]);
        dfs(i, result, current, total+nums[i], target, nums);
        current.remove(current.size()-1);
        dfs(i+1, result, current, total, target, nums);
    }
}
