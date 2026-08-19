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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }

        int leftVal = root.left.val;
        int rightVal = root.right.val;

        // If left child has the same value as root, search deeper in left subtree
        if (leftVal == root.val) {
            leftVal = findSecondMinimumValue(root.left);
        }

        // If right child has the same value as root, search deeper in right subtree
        if (rightVal == root.val) {
            rightVal = findSecondMinimumValue(root.right);
        }

        // If both subtrees found a candidate, return the smaller one
        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }

        // Otherwise, return whichever candidate is valid (or -1 if neither is)
        return leftVal != -1 ? leftVal : rightVal;
    }
}