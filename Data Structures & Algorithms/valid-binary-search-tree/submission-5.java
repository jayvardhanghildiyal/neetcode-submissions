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

    public boolean func(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        } else if (root.val > min && root.val < max) {
            return func(root.left, min, root.val) && func(root.right, root.val, max);
        } else {
            return false;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return func(root.left, Integer.MIN_VALUE, root.val) && func(root.right, root.val, Integer.MAX_VALUE);
    }
}
