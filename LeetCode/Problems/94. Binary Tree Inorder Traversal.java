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
    
    void recur(TreeNode node, List<Integer> al) {
        
        if (node == null) return;
        
        recur(node.left, al);
        
        al.add(node.val);
        
        recur(node.right, al);
        
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        
        List<Integer> al = new ArrayList<>();
        
        recur(root, al);
        
        return al;
        
    }
}