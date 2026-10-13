class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> hashSet = new HashSet<>();
        
        for (int i = 0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        if (!dfs(0, -1, map, hashSet)) {
            return false;
        }

        return hashSet.size() == n;
    }

    private boolean dfs(int node, int prev, Map<Integer, List<Integer>> map, Set<Integer> set) {
        if (set.contains(node)) {
            return false;
        }
        set.add(node);

        List<Integer> neigh = map.getOrDefault(node, new ArrayList<>());

        for (int nei: neigh) {
            if ( nei == prev) {
                continue;
            }
            if (!dfs(nei, node, map, set)) {
                return false;
            }

        }

        return true;
    }

}
