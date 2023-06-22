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

  int maxElementIndex(int arr[], int low, int high) {
    for (int i = low; i <= high; i++) if (arr[i] > arr[low]) return i;

    return -1;
  }

  TreeNode bstRecur(int preorder[], int low, int high) {
    if (low - high == 0) return new TreeNode(preorder[low]);

    TreeNode node = new TreeNode(preorder[low]);

    int mid = maxElementIndex(preorder, low, high);

    if (mid == -1) {
      node.right = null;
      node.left = bstRecur(preorder, low + 1, high);
    } else if (mid == low + 1) {
      node.left = null;
      node.right = bstRecur(preorder, low + 1, high);
    } else {
      node.left = bstRecur(preorder, low + 1, mid - 1);
      node.right = bstRecur(preorder, mid, high);
    }

    return node;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    // time complexity - n^2

    return bstRecur(preorder, 0, preorder.length - 1);
  }
}
