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
    // Iterative BFS
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        int level = 0;
        while(!queue.isEmpty()) {
            int val = queue.size();
            for (int i=0;i<val;i++) {
                TreeNode node = queue.poll();
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            level++;
        }

        return level;
    }

 
}
