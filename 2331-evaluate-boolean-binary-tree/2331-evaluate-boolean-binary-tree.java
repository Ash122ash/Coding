class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        // Evaluate children first so they become resolved 0 or 1
        evaluateTree(root.left);
        evaluateTree(root.right);

        if (root.val == 2) {
            root.val = root.left.val | root.right.val;
        } else if (root.val == 3) {
            root.val = root.left.val & root.right.val;
        }

        return root.val == 1;
    }
}