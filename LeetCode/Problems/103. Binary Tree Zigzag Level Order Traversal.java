// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        List<List<Integer>> al = new ArrayList<>();

        boolean odd = true;

        if (root == null)
            return al;

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            List<Integer> tempList = new ArrayList<>();

            while (!stack1.isEmpty()) {

                TreeNode node = stack1.pop();

                tempList.add(node.val);

                if (odd) {

                    if (node.left != null)
                        stack2.push(node.left);

                    if (node.right != null)
                        stack2.push(node.right);

                } else {

                    if (node.right != null)
                        stack2.push(node.right);

                    if (node.left != null)
                        stack2.push(node.left);

                }

            }

            al.add(tempList);

            odd = !odd;

            Stack t = stack1;
            stack1 = stack2;
            stack2 = t;

        }

        return al;
    }
}