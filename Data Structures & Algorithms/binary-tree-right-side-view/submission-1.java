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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> response = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // BFS solution
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Integer rightMost = null;
            for (int i = 0; i<size; i++) {
                TreeNode node = queue.poll();
                
                if (node!=null) {
                    rightMost = node.val;
                    queue.add(node.left);
                    queue.add(node.right);
                }
                    if (rightMost!=null && (i == (size-1))) {
                        response.add(rightMost);
                    }
            }
        }

        return response;
    }
}
