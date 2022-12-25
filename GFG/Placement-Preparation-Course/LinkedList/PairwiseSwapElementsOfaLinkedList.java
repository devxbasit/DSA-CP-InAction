import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        	int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            Solution g = new Solution();
            head = g.pairwiseSwap(head);
            printList(head); 
            t--;
        }
    } 
} 
   
// } Driver Code Ends



/* node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/


class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head)
    {
        // code here
        if (head == null || head.next == null){
            return head;
        }
        
        Node prev = head;
        Node curr = head.next;
        Node next = null;
        
        head = curr;
        
        while (true){

            next = curr.next;
            
            curr.next = prev;
            
            
            if (next == null || next.next == null){
                prev.next = next;
                break;
            }
            
            prev.next = next.next;
            prev = next;
            curr = prev.next;

        }
        
        return head;
    }
}