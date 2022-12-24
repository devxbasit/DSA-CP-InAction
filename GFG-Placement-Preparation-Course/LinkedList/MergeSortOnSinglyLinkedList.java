//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new LinkedList().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

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
                
                curr = l1;
                l1 = l1.next;
                
            }else {
                
                curr.next = l2;
                
                curr = l2;
                l2 = l2.next;
                
            }
        }
        
        if (l1 == null)
            curr.next = l2;
        else
            curr.next = l1;
            
        return head;
    }
    
    public static Node mergeSort(Node head)
    {
        // add your code here
        if (head == null || head.next == null)
            return head;
            
        Node firstHalf = getMid(head);

        Node secondHalf = firstHalf.next;
        
        firstHalf.next = null;
        
            
        Node h1 = mergeSort(head);
        Node h2 = mergeSort(secondHalf);
        
        return merge(h1, h2);
    }
}
