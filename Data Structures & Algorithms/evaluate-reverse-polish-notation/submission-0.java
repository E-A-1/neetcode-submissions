class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> eval = new Stack<>();
        for (String s: tokens) {
            if (s.equals("+")) {
                eval.push(eval.pop()+eval.pop());
            }
            else if (s.equals("-")) {
                int a = eval.pop();
                int b = eval.pop();
                eval.push(b-a);
            }
            else if (s.equals("*")) {
                eval.push(eval.pop()*eval.pop());
            }
            else if (s.equals("/")) {
                int a = eval.pop();
                int b = eval.pop();
                eval.push(b/a);
            }
            else {
                eval.push(Integer.parseInt(s));
            }
        }

        return eval.pop();
    }
}
