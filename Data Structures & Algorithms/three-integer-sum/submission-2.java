class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            Arrays.sort(nums);
            int a = nums[i];
            if ((i > 0) && (a == nums[i-1])) {
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = (a + nums[left] + nums[right]);
                if ( sum == 0) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(a);
                    newList.add(nums[left]);
                    newList.add(nums[right]);
                    list.add(newList);
// 2. Move pointers inward
            left++;
            right--;
            
            // 3. Skip duplicates for the left pointer to avoid identical triplets
            while (left < right && nums[left] == nums[left - 1]) {
                left++;
            }
            }
            else if (sum > 0) {
                    right--;
            }
                else {
                    left++;
                }
            }
        }

        return list;
    }
}
