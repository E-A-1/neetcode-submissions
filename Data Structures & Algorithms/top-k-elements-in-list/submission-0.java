class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i< nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Integer> intList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> intt: map.entrySet()) {
            if (intt.getValue() >= k) {
                intList.add(intt.getKey());
            }
        }

        int[] opArr = new int[intList.size()];

        for (int j=0;j<intList.size();j++) {
            opArr[j] = intList.get(j);
        }

        return opArr;
    }
}
