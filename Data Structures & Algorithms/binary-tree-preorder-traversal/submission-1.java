// iterative traversal

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        // used for storing right subtrees only
        // the left subtrees are recorded upon arrival
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                // add the node to the list
                answer.add(curr.val);
                // store right subtree for traversal
                // once we run out of left subtrees
                stack.add(curr.right);
                // travel further right
                curr = curr.left;
            } else {
                // when there are no more left subtrees to traverse
                curr = stack.pop();
            }
        } 

        return answer;
    }
}

// 3, 5