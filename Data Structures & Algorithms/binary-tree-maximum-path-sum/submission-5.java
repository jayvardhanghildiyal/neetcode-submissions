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
    int max = Integer.MIN_VALUE;
    public int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int sum = root.val;

            int num1 = maxPath(root.left);
            int num2 = maxPath(root.right);

            int num3 = Math.max(sum, Math.max(sum + num1, sum + num2));
            max = Math.max(max, Math.max(num3, sum + num1 + num2));
            return num3;
        }
    }

    public int maxPathSum(TreeNode root) {
        maxPath(root);

        return max;
    }
}
