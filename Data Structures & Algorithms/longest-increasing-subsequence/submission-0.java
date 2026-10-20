class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int maxValue = nums.length > 0 ? 1: 0;
        for (int i = nums.length; i>=0; i--) {
            for (int j=i+1; j<nums.length;j++) {
                if (nums[i] < nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                    maxValue = Math.max(maxValue, lis[i]);

                }

            }
        }

        return maxValue;
    }
}
