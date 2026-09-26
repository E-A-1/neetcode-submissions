/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        int n = 0;
        while (!(stack.isEmpty()) || current!=null) {
            while (current!=null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            n = n+1;
            if (n == k) {
                return current.val;
            }
            current = current.right;
        }
        return 0;
    }
}
