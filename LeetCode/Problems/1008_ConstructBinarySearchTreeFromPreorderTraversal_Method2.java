// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

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

  TreeNode bstRecur(int preorder[], int n, int currIndex, int min, int max) {
    // time complexity - n^2

    for (; currIndex < n; currIndex++) if (
      preorder[currIndex] > min && preorder[currIndex] < max
    ) break;

    if (currIndex >= n) return null;

    TreeNode node = new TreeNode(preorder[currIndex]);

    node.left = bstRecur(preorder, n, currIndex + 1, min, node.val);
    node.right = bstRecur(preorder, n, currIndex + 1, node.val, max);

    return node;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    return bstRecur(
      preorder,
      preorder.length,
      0,
      Integer.MIN_VALUE,
      Integer.MAX_VALUE
    );
  }
}
