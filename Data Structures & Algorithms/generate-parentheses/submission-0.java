class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        backTrack(n, 0,0, result, s);

        return result;
    }

    private void backTrack(int n, int open, int closed, List<String> result, StringBuilder stack) {

        if ((open == closed) && (closed== n)) {
            result.add(stack.toString());
            return;
        }

        if (open<n) {
            stack.append("(");
            backTrack(n, open+1, closed, result, stack);
            stack.deleteCharAt(stack.length()-1);
        }

        if (closed<open) {
            stack.append(")");
            backTrack(n, open, closed+1, result, stack);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
