// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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

  int val = -1;
  int i = -1;

  boolean recur(TreeNode root) {
    if (root == null) return false;

    if (recur(root.left)) return true;

    i--;

    if (i == 0) {
      val = root.val;
      return true;
    }

    return recur(root.right);
  }

  public int kthSmallest(TreeNode root, int k) {
    i = k;
    recur(root);

    return val;
  }
}
