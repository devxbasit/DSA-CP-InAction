/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
    
    class Index {
        
        int i;
    
    }
    
    void serHelper(TreeNode node, StringBuilder S) {
        
        if (node == null) { 
            
            S.append("$,");
            return ;
        }
        
        S.append(Integer.toString(node.val) + ",");
        
        serHelper(node.left, S);
        serHelper(node.right, S);
        
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder S = new StringBuilder();
        serHelper(root, S);
        
        return S.toString();
    }

    TreeNode desHelper(String S[], Index index) {
        
        if (S[index.i].equals("$")) {
          
            index.i++;
            return null;
            
        } 
        
        
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(S[index.i]);
        
        index.i++;
        root.left = desHelper(S, index);
        
        root.right = desHelper(S, index);
        
        return root;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String S[] = data.split(",");
        
        Index index = new Index();
        index.i = 0;
        
        return desHelper(S, index);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));