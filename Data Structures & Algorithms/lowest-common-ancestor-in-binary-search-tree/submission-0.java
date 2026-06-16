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
    public TreeNode func(TreeNode root, TreeNode p, TreeNode q) {
        // if (p.val >= root && q.val <= root) {
        //     return root;
        // } else if (p.val <= root && q.val >= root) {
        //     return root;
        // } else 
        if (p.val > root.val && q.val > root.val) {
            return func(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return func(root.left, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return func(root, p, q);
    }
}
