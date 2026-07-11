class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i< n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > stack.peek()[0]) {
                res[stack.peek()[1]] = i - stack.peek()[1];
                stack.pop();
            }
            stack.push(new int[]{temp, i});
        }

        return res;
    }
}
