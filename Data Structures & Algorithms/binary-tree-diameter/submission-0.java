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
    int maxDia = 0;
    public int mdia(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftD = mdia(root.left);
            int rightD = mdia(root.right);

            maxDia = Math.max(maxDia, leftD + rightD);

            return 1 + Math.max(leftD, rightD);
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        mdia(root);

        return maxDia;
    }
}
