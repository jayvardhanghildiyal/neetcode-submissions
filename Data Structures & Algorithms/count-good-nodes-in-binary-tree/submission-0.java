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
    int count = 0;
    public void counting(TreeNode root, int max) {
        if (root == null) {
            return ;
        } else if (root.val >= max) {
            count += 1;
            counting(root.left, root.val);
            counting(root.right, root.val);
        } else {
            counting(root.left, max);
            counting(root.right, max);
        }
    }

    public int goodNodes(TreeNode root) {
        counting(root, root.val);
        return count;
    }
}
