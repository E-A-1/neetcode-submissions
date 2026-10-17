class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0], 
            Math.max(
                comeOnRob(Arrays.copyOfRange(nums, 0, nums.length-1)),
                comeOnRob(Arrays.copyOfRange(nums, 1, nums.length))
            )
        );
    }

    private int comeOnRob(int[] nums) {
        int rob1 = 0,rob2 = 0;
        for (int num: nums) {
            int temp = Math.max(num+rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
