class Solution {
    private  Set<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target)        { 
                result = new HashSet<>();
                Arrays.sort(candidates);
        List<Integer>  current = new ArrayList<>();
        dfs(0, result, current, 0, target, candidates);
        return new ArrayList<>(result);
    }

    private void dfs(int i, Set<List<Integer>> result,List<Integer>  current, int total, int target, int[] nums ) {
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (i >= nums.length || total>target) {
            return;
        }

        current.add(nums[i]);
        dfs(i+1, result, current, total+nums[i], target, nums);
        current.remove(current.size()-1);
while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(i+1, result, current, total, target, nums);
    }
}
