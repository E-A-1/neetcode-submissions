class Solution {
    public boolean canPartition(int[] nums) {
        if (Arrays.stream(nums).sum()%2 != 0) {
            return false;
        }
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        int target = Arrays.stream(nums).sum() / 2;
        for (int i = nums.length - 1; i>=0; i--) {
            Set<Integer> nDp = new HashSet<>();
            for (int t: dp) {
                if (t + nums[i] == target) {
                    return true;
                }
                nDp.add(t + nums[i]);
                nDp.add(t);
            }
            dp = nDp;
        }

        return false;
    }

}
