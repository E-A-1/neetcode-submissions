class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        // Part -1: Building the adjaceny list
        for (int i = 0; i<N; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j=i+1; j<N; j++) {
                int x2 = points[j][0];
                int y2= points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);

                adj.computeIfAbsent(i, k->new ArrayList<>()).add(
                    new int[] {
                        dist, j
                    }
                );
                adj.computeIfAbsent(j, k->new ArrayList<>()).add(
                    new int[] {
                        dist, i
                    }
                );
            }
        }

        int res = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> minH = new PriorityQueue<>(
            Comparator.comparingInt(a->a[0])
        );
        minH.offer(new int[]{0,0});
        while(visit.size()<N) {
            int[] curr = minH.poll();
            int cost = curr[0];
            int node = curr[1];
            if (visit.contains(node)) {
                continue;
            }
            res+=cost;
            visit.add(node);

            for (int[] nei: adj.getOrDefault(node, 
            Collections.emptyList())) {
                int neiCost = nei[0];
                int neiNode = nei[1];
                if (!visit.contains(neiNode)) {
                    minH.offer(new int[]{
                        neiCost, neiNode
                    });
                }
            }
        }
        return res;
    }
}
