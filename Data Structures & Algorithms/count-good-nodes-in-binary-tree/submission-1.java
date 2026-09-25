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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int maxValue) {
        int res = 0;
        if (root==null) {
            return res;
        }
        if (root.val>=maxValue) {
            res = 1;
        }
        maxValue = Math.max(root.val, maxValue);
        res = res + dfs(root.left, maxValue);
        res = res + dfs(root.right, maxValue);

        return res;
    }
}
