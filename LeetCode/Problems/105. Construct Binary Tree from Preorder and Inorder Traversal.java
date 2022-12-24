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
    
    TreeNode dfsRecur(int preorder[], int preLow, int preHigh, int inorder[], int inLow, int inHigh) {
        
        if (preLow > preHigh) return null;
        
        
        if (preLow == preHigh) return new TreeNode(preorder[preLow]);
        
        TreeNode node = new TreeNode(preorder[preLow]);

        
        int mid = inLow;
        while (inorder[mid] != preorder[preLow]) mid++;
        
        node.left = dfsRecur(preorder, preLow + 1, preLow + (mid - inLow), inorder, inLow, mid - 1);
        
        node.right = dfsRecur(preorder, preLow + (mid - inLow) + 1, preHigh, inorder, mid + 1, inHigh);
        
        return node;
        
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return dfsRecur(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        
    }
}