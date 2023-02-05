// https://leetcode.com/problems/binary-tree-level-order-traversal/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> al = new ArrayList<>();

        if (root == null)
            return al;

        queue.add(root);
        queue.add(null);

        while (queue.size() > 1) {

            List<Integer> temp = new ArrayList<>();

            while (queue.peek() != null) {

                TreeNode node = queue.remove();

                temp.add(node.val);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

            }

            al.add(temp);

            // remove null marker
            queue.remove();

            queue.add(null);

        }

        return al;
    }
}
