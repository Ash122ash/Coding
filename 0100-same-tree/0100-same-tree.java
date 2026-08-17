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

    public boolean compare(TreeNode p, TreeNode q) {

        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One node is null, other is not
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Compare left and right subtrees
        return compare(p.left, q.left) &&
               compare(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }
}