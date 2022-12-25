// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG
{
    
    static Node buildTree(String str){
        
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            String s = br.readLine();
	            int x = Integer.parseInt(br.readLine());
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			    root = g.deleteNode(root,x);
			    printInorder(root);
			    System.out.println();
                t--;
            
        }
    }
  
}

// } Driver Code Ends


//User function Template for Java

/*
Structure of a Node is as follows:-
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Tree
{
    // Return the root of the modified BST after deleting the node with value X
    
    static int getInorderPredecessor(Node node){
        
        if (node.right == null)
            return node.data;
            
        return getInorderPredecessor(node.right);
    }
    
    static Node deleteInorderPredecessorRecur(Node node){
        
        if (node.right == null)
            return node.left;
            
        node.right = deleteInorderPredecessorRecur(node.right);
        
        return node;
    }
    
    public static Node deleteNode(Node root, int X){
        // code here
        
        if (root == null)
            return null;
            
        if (X > root.data)
            root.right = deleteNode(root.right, X);
        else if (X < root.data) 
            root.left = deleteNode(root.left, X);
        else {
            
            // root == key
            
            if (root.right == null)
                return root.left;
            
            if (root.left == null)
                return root.right;
                
            // else root has two childs
            
            root.data = getInorderPredecessor(root.left);
            
            root.left = deleteInorderPredecessorRecur(root.left);
            
        }
        
        return root;
	}
}	