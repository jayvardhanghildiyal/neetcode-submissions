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
    public void traversal(TreeNode root) {
        if (root == null) {
            return ;
        }
        traversal(root.left);
        traversal(root.right);

        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
        traversal(root);

        return root;
    }
}
