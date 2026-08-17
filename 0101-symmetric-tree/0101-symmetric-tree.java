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

    public boolean issame(TreeNode left, TreeNode right) {

        // Both are null
        if (left == null && right == null) {
            return true;
        }

        // One is null
        if (left == null || right == null) {
            return false;
        }

        // Values are different
        if (left.val != right.val) {
            return false;
        }

        // IMPORTANT:
        // left's left  ↔ right's right
        // left's right ↔ right's left
        return issame(left.left, right.right) &&
               issame(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return issame(root.left, root.right);
    }
}