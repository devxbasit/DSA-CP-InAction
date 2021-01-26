// { Driver Code Starts
//Initial template for Java

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

class GFG {
    
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
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            String line = br.readLine();
            String[] splitLine = line.split(" ");
            int nd1 = Integer.parseInt(splitLine[0]);
            int nd2 = Integer.parseInt(splitLine[1]);
            int turn;

            Tree g = new Tree();
            if((turn = g.NumberOfTurns(root, nd1, nd2)) != 0)
              System.out.println(turn);
            else
              System.out.println("-1");
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Tree
{
    static Node lca (Node node, int a, int b){
        
        if (node == null)
            return null;
        
        if (node.data == a || node.data == b)
            return node;
            
        Node left = lca(node.left, a, b);
        
        Node right = lca(node.right, a, b);
        
        if (left == null)
            return right;
        
        if (right == null)
            return left;
            
        return node;
    }
    
    
    static int turnsRecur(Node node, int a, int b, int count, char direction){
        
        if (node == null)
            return -1;
            
        if (node.data == a || node.data == b)
            return count;
            
        int left;
            
        if (direction == 'l'){
            
            left = turnsRecur(node.left, a, b, count, direction);
            
            return (left != -1) ? left : turnsRecur(node.right, a, b, count + 1, 'r');
        } else {
            
            
            left = turnsRecur(node.left, a, b, count + 1, 'l');
                
            return (left != -1) ? left : turnsRecur(node.right, a, b, count, direction);
        }
    }
    
    
    static int NumberOfTurns(Node root, int first, int second)
    {
        //your code here
        
        Node lca = lca(root, first, second);
        
        int turns;
        
        if (lca.data == first){
            
            turns = turnsRecur(lca.left, second, second, 0, 'l');

            turns = (turns != -1) ? turns : turnsRecur(lca.right, second, second, 0, 'r');

            return (turns == 0) ? -1 : turns;            
            
        }else if (lca.data == second){
            
            turns = turnsRecur(lca.left, first, first, 0, 'l');

            turns = (turns != -1) ? turns : turnsRecur(lca.right, first, first, 0, 'r');

            return (turns == 0) ? -1 : turns;            
        }
        
        int a = turnsRecur(lca.left, first, second, 0, 'l');
        int b = turnsRecur(lca.right, first, second, 0, 'r');
        
        return a + b + 1;
    }
}