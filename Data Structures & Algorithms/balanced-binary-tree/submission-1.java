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
    int diff = 1;
    public int heightCheck(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        } else {
            depth += 1;
            int leftD = heightCheck(root.left, depth);
            int rightD = heightCheck(root.right, depth);

            diff = Math.max(diff, Math.abs(leftD - rightD));

            if (leftD > rightD) {
                return leftD;
            } else {
                return rightD;
            }
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        int num = heightCheck(root, 0);
        return diff > 1 ? false : true;
    }
}
