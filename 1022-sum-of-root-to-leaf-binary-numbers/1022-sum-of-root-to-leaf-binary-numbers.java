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

    public int sum(TreeNode root, StringBuilder a) {

        if (root == null) {
            return 0;
        }

        // Add current node to binary string
        a.append(root.val);

        // If leaf node, convert binary string to decimal
        if (root.left == null && root.right == null) {
            int num = Integer.parseInt(a.toString(), 2);

            // Remove current node before returning
            a.deleteCharAt(a.length() - 1);

            return num;
        }

        // Go left
        int left = sum(root.left, a);

        // Go right
        int right = sum(root.right, a);

        // Remove current node while going back
        a.deleteCharAt(a.length() - 1);

        return left + right;
    }

    public int sumRootToLeaf(TreeNode root) {

        if (root == null) {
            return 0;
        }

        StringBuilder a = new StringBuilder();

        return sum(root, a);
    }
}