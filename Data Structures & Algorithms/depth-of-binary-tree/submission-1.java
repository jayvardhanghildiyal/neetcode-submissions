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
    public int md(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        } else {
            depth += 1;
            int leftD = md(root.left, depth);
            int rightD = md(root.right, depth);

            if (leftD > rightD) {
                return leftD;
            } else {
                return rightD;
            }
        }
    }

    public int maxDepth(TreeNode root) {
        return md(root, 0);
    }
}
