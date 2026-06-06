class Solution {
    // Trying the PriorityQueue thing
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i< nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.offer(entry.getKey());
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int response[] = new int[k];
        for (int i=0; i<k;i++) {
            response[i]= queue.poll();
        }
        // List<Integer> intList = new ArrayList<>(map.keySet());
        // intList.sort((a,b)->map.get(b) - map.get(a));
        
        // int[] opArr = new int[k];
        // for (int i = 0; i<k; i++) {
        //     opArr[i] = intList.get(i);
        // }

        // return opArr;
        return response;
    }
}
