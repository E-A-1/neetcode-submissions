class Solution {
    public int maxProduct(int[] nums) {
        int maxSum = nums[0];
        int curMin = 1, curMax = 1;
        for (int i=0; i<nums.length;i++) {
            int num = nums[i];
            int tmp = curMax * num;
            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            maxSum = Math.max(maxSum, curMax);
        }

        return maxSum;
    }
}
