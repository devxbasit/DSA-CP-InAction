// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static Node addLists(Node first, Node second){
        // code here
        // return head of sum list
        
        if (first == null)
            return second;
        
        if (second == null)
            return first;
            
    
        //reverse first linked list
        Node prev = null;
        Node next = null;
        Node curr = first;
        
        while (curr.next != null){
            
            next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        
        curr.next = prev;
        first = curr;
        
        
        
        //reverse second linked list
        prev = null;
        next = null;
        curr = second;
        
        while (curr.next != null){
            
            next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        
        curr.next = prev;
        second = curr;
        
        // perform addition and maintian carry
        
        int carry = 0;
    
        Node x = first;
        Node y = second;
        Node z = null;
        
        while (x != null && y != null){
            
            int sum = carry + x.data + y.data;
            
            Node newNode = new Node(sum % 10);
            
            if (z == null)
                z = newNode;
            else{
                newNode.next = z;
                z = newNode;
            }
                
            carry = sum / 10;
            
            x = x.next;
            y = y.next;
        }
        
    
        while (x != null){
            
            int sum = x.data + carry;
            
            Node newNode = new Node(sum % 10);
            
            newNode.next = z;
            z = newNode;
            
            carry = sum / 10;
            x = x.next;
        }
        
        
        while (y != null){
            
            int sum = y.data + carry;
            
            Node newNode = new Node(sum % 10);
            
            newNode.next = z;
            z = newNode;
            
            carry = sum / 10;
            y = y.next;
        }
        
        
        if (carry != 0){
            
            Node newNode = new Node(carry);
            newNode.next = z;
            z = newNode;
        }
        
        
        return z;
        
    }
}