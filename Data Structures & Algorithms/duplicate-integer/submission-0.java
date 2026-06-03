class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]) + 1;
                map.put(nums[i], value);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                return true;
            }
        }

        return false;
    }
}