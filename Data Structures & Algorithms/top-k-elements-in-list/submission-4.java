class Solution {
    // Trying the Bucketing Algorithm
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0;i< nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            list.add(new ArrayList<>());
        }
        // Because array starts from 0, we need a additional buffer in memory if
        // all the elements in array are same
        list.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            list.get(entry.getValue()).add(entry.getKey());
        }
        int index = 0;
        int response[] = new int[k];
        for (int i = list.size()-1; i>0 && index < k;i--) {
            for(int j: list.get(i)){
                response[index++] = j;
            }
        }
        return response;
    }
}
