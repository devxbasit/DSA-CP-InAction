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
    
    class Index{
        
        int i;
        
        Index(int i){
            this.i = i;
        }
        
    }
    
    TreeNode bstRecur(int preorder[], int n, Index index, int min, int max){
  
        if (index.i >= n)
            return null;
        
        TreeNode root = null;
        
        if (preorder[index.i] > min && preorder[index.i] < max){
            
            root = new TreeNode(preorder[index.i]);
            
            index.i = index.i + 1;

            root.left = bstRecur(preorder, n, index, min, root.val);
            
            root.right = bstRecur(preorder, n, index, root.val, max);
        }
        
        return root;
    }
    

    public TreeNode bstFromPreorder(int[] preorder) {


        // time complexity - n 
               
        Index index = new Index(0);
        return bstRecur(preorder, preorder.length, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
}