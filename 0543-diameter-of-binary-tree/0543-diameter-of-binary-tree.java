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
   int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
       
        getHeight(root);
        return maxDiameter;
    }

    // Helper method: returns the height of the subtree
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // Update the maximum diameter found so far (in terms of number of edges)
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of current node to its parent
        return 1 + Math.max(leftHeight, rightHeight);
    }
}