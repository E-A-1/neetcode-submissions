class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if ((hand.length%groupSize)!=0) return false;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: hand){
            count.put(num, count.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count.keySet());

        while (!minHeap.isEmpty()) {
            int minValue = minHeap.peek();
            for (int i=minValue; i<minValue+groupSize;i++) {
                if (!count.containsKey(i)) {
                    return false;
                }
                count.put(i, count.getOrDefault(i, 0) - 1);
                if (count.get(i) == 0) {
                    if (i!=minHeap.peek()) {
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }
        return true;
    }
}
