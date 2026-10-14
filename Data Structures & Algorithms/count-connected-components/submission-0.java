class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int response = 0;
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for (int i=0; i<n; i++) {
            if (!set.contains(i)) {
                dfs(i, map, set);
                response++;
            }
        }

        return response;
    }

    private void dfs(int node, Map<Integer, List<Integer>> map, Set<Integer> set) {
        set.add(node);
        List<Integer> neighbors = map.getOrDefault(node, new ArrayList<>());
        for (int nei: neighbors) {
            if (!set.contains(nei)) {
                dfs(nei, map, set);
            }
        }
    }
}
