class Solution {
    public int longestConsecutive(int[] nums) {
        // Second Attempt using HashSet - Better one
        if (nums.length == 0 ) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int streak = 1;
        int longestStreak = 1;
        for (int num: nums) {
            if (!set.contains(num-1)) {
            while (set.contains(num+1)) {
                num++;
                streak++;
            }
            longestStreak = Math.max(longestStreak, streak);
            streak = 1;
            }
        }

        return longestStreak;
    }
}
