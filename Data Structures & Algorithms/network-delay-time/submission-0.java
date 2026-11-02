class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time: times) {
            edges.computeIfAbsent(time[0], 
            key -> new ArrayList<>()).add(new int[]{
                time[1], time[2]
            });
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparing(a->a[0])
        );
        minHeap.offer(new int[]{
            0, k
        });

        Set<Integer> visited = new HashSet<>();
        int t = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int weight = curr[0], node = curr[1];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            t = Math.max(weight, t);
            if (edges.containsKey(node)) {
                for (int[] next: edges.get(node)) {
                    int node2= next[0], weight2 = next[1];
                    if (!visited.contains(node2)) {
                        minHeap.offer(new int[] {weight2+weight, node2});
                    }
                }
            }

        }
            return visited.size() == n ? t : -1;

    }
}
