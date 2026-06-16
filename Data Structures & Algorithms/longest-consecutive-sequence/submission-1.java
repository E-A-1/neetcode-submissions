class Solution {
    public int longestConsecutive(int[] nums) {
        // First attempt - Own logic
        if (nums.length == 0 ) {
            return 0;
        }
        Arrays.sort(nums);
        int streak = 1;
        // bool isStreak = false;
        int longStreak = 1;
        for (int i = 0; i < nums.length-1; i++) {
            int currentNumber = nums[i];
            int nextNumber = nums[i+1];
            if (((currentNumber + 1) == nextNumber) || (nextNumber == currentNumber)) {
                if (!(nextNumber == currentNumber)) {
                    streak++;
                }
               
               if ( i == nums.length-2) {
                    longStreak = Math.max(longStreak, streak);
               }
            }
            else {
                longStreak = Math.max(longStreak, streak);
                streak = 1;
            }
        }


        return longStreak;
    }
}
