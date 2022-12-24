

import java.util.*;
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next, prev;
    Node(int key)
    {
        data = key;
        next = prev = null;
    }
}

class Driverclass
{
    public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        int a1 = sc.nextInt();
	        Node head = new Node(a1);
	        Node temp = head;
	        
	        for (int i = 1;i < n;i++)
	        {
	            int a = sc.nextInt();
	            Node n1 = new Node(a);
	            n1.prev = temp;
	            temp.next = n1;
	            temp = n1;
	        }
	        
	        head = new LinkedList().sortDoubly(head);
	        printList(head);
	    }
	}
	public static void printList(Node node)
	{
	    Node temp = node;
	    while(node != null)
	    {
	        System.out.print(node.data + " ");
	        temp = node;
	        node = node.next;
	    }
	    System.out.println();
	    while(temp != null)
	    {
	        System.out.print(temp.data + " ");
	        temp = temp.prev;
	    }
	    System.out.println();
	}
}
// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class LinkedList
{
    public static Node getMid(Node head){
    
        if (head.next == null)
            return head;
            
        Node slow = head;
        Node fast = head;
        
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    
    public static Node merge(Node firstHalf, Node secondHalf){

        Node head = null;
        
        Node l1 = firstHalf;
        Node l2 = secondHalf;
        
        Node curr = null;
        
        if (l1.data < l2.data){
            
            head = l1;
            
            curr = l1;
            l1 = l1.next;
        }else {
            
            head = l2;
            
            curr = l2;
            l2 = l2.next;
        }
        
        
        while (l1 != null && l2 != null){
            
            if (l1.data < l2.data){
                
                curr.next = l1;
                l1.prev = curr;
                
                curr = l1;
                l1 = l1.next;
                
            }else {
                
                curr.next = l2;
                l2.prev = curr;
                
                curr = l2;
                l2 = l2.next;
                
            }
        }
        
        if (l1 == null){
            curr.next = l2;
            l2.prev = curr;
        } else {
            curr.next = l1;
            l1.prev = curr;
        }
            
        return head;
    }
    
    static Node sortDoubly(Node head)
    {
        // add your code here
 
        if (head == null || head.next == null)
            return head;
            
        Node firstHalf = getMid(head);

        Node secondHalf = firstHalf.next;
        
        firstHalf.next = null;
        secondHalf.prev = null;
       
        Node h1 = sortDoubly(head);
        Node h2 = sortDoubly(secondHalf);
        
        return merge(h1, h2);
    }
}