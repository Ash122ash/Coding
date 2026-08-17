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
    public int maxDepth(TreeNode root) {
        if (root == null) {                                // Line 1
        return 0;                                      // Line 2
    }
    int leftDepth = maxDepth(root.left);               // Line 3
    int rightDepth = maxDepth(root.right);             // Line 4
    return 1 + Math.max(leftDepth, rightDepth);        // Line 5
}}