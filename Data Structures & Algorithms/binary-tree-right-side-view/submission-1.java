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
    List<List<Integer>> list = new ArrayList<>();

    public void bfs(TreeNode root, int level) {
        if (root == null) {
            return ;
        } else {
            if (list.size() <= level) {
                list.add(new ArrayList<>());
            }

            list.get(level).add(root.val);
            bfs(root.left, level + 1);
            bfs(root.right, level + 1);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        bfs(root, 0);

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (List<Integer> array : list) {
            arr.add(array.get(array.size() - 1));
        }

        return arr;
    }
}
