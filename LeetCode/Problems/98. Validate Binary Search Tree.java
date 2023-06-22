// https://leetcode.com/problems/validate-binary-search-tree/
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

  boolean helper(TreeNode root, Integer min, Integer max) {
    if (root == null) return true;

    if (max != null && root.val >= max) return false;

    if (min != null && root.val <= min) return false;

    return (
      helper(root.left, min, root.val) && helper(root.right, root.val, max)
    );
  }

  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }
}
