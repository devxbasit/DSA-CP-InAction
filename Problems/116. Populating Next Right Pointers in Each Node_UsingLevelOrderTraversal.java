/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    public Node connect(Node root) {
        
        if (root == null) return root;
    
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        queue.add(null);
        
        while (queue.size() > 1) {
            
            Node node = queue.remove();
            
            if (node == null) {
                
                queue.add(null);
                continue;
                
            }
            
            if (node.left != null) queue.add(node.left);
            
            if (node.right != null) queue.add(node.right);
            
            
            if (queue.peek() != null) {
                
                node.next = queue.peek();
              
            }    
        }
        
        return root;
    }
}