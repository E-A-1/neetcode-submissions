class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left < right) {
            int computedTarget = numbers[left]+ numbers[right];
            if (computedTarget == target) {
                return new int[] {left+1, right+1};
            }

            int rem = target - computedTarget;

            if (computedTarget > target) {
                right--;
            }
            else {
                left++;
            }
        }

        return new int[]{};
    }
}
