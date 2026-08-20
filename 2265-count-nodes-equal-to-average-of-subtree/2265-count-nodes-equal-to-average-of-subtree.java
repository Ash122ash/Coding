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
    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;

        // 1. Calculate sum and count for the current subtree using BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        int count = 0;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            sum += curr.val;
            count++;

            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }

        // 2. Check if the current root satisfies the condition
        int selfMatch = (sum / count == root.val) ? 1 : 0;

        // 3. Recursively sum matches from left and right subtrees
        return selfMatch + averageOfSubtree(root.left) + averageOfSubtree(root.right);
    }
}