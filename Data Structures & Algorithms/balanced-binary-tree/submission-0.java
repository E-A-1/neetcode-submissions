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
    public boolean isBalanced(TreeNode root) {
        int[] answer = dfs(root);
        boolean isCorrect =  answer[0] == 1 ? true : false;
        return isCorrect; 
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean isBalance = (left[0] == 1 && right[0] == 1) && Math.abs(left[1] - right[1]) <=1;
        int isBalanced = isBalance ? 1 : 0;
        return new int[]{isBalanced, 1+Math.max(left[1],right[1])};
    }
}
