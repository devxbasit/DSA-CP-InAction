// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
}

class BinarySearchTree
{
     
static Node buildTree(String str)
    {
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
         public static void main (String[] args) throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int t=Integer.parseInt(br.readLine());
            
            while(t > 0){
                String s = br.readLine();
                Node root = buildTree(s);
                String nums = br.readLine();
                String[] s1 = nums.split(" ");
                int oldKey=Integer.parseInt(s1[0]);
                int new_key=Integer.parseInt(s1[1]);

			GfG g=new GfG();
			root=g.changeKey(root,oldKey,new_key);
			inorder(root);
			System.out.println();
                t--;
        }
    }
    
  static void inorder(Node root)
    {
        if(root != null)
         {
        inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
         }
    }
    

}
// } Driver Code Ends


/* A binary search tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */
// your task is to complete the below function
class GfG {
    
    static int getInorderPredecessor(Node node){
        
        if (node.right == null)
            return node.data;
            
        return getInorderPredecessor(node.right);
        
    }
    
    static Node deleteInorderPredecessor(Node node){
        
        if (node.right == null)
            return node.left;
            
        node.right = deleteInorderPredecessor(node.right);
            
        return node;
    }
    
    static Node deleteNode(Node node, int key){
        if (node == null)
            return null;
            
        if (key > node.data)
            node.right = deleteNode(node.right, key);
        else if (key < node.data)
            node.left = deleteNode(node.left, key);
        else{
            
            if (node.right ==  null)
                return node.left;
                
            if (node.left == null)
                return node.right;
                
            node.data = getInorderPredecessor(node.left);
            
            node.left = deleteInorderPredecessor(node.left);
        } 
        
        return node;
    }
    
    
    static Node addNode(Node node, int key){
        
        if (node == null)
            return new Node(key);
        
        if (key > node.data)
            node.right = addNode(node.right, key);
        else if(key < node.data)
            node.left = addNode(node.left, key);
        else {
            
            Node duplicate = new Node(key);
            
            duplicate.left = node.left;
            
            node.left = duplicate;
            
        }
     
            
        return node;
    }
    
    public static Node changeKey(Node root, int old_key, int new_key) {
        
        // your code here
        
        root = deleteNode(root, old_key);
        
        return addNode(root, new_key);
    }
}