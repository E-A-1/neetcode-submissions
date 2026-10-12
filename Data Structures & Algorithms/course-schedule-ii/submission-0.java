class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preReq = new HashMap<>();
        for (int[] pre: prerequisites) {
            preReq.computeIfAbsent(pre[0],
                k -> new ArrayList<>()).add(pre[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for (int course =0; course<numCourses; course++) {
            if (!dfs(course, preReq, visit, cycle, output)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i=0;i<numCourses;i++) {
            result[i] = output.get(i);
        }

        return result;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> preReq, Set<Integer> visit, Set<Integer> cycle, List<Integer> output) {
        if (cycle.contains(course)) {
            return false;
        }

        if (visit.contains(course)) {
            return true;
        }

        cycle.add(course);

        for (int pre: preReq.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(pre, preReq, visit, cycle, output)) {
                return false;
            }
        }

        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
}
