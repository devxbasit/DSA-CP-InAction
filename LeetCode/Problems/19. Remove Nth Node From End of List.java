/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    class Counter {
        
        int counter;
        Counter(int counter) { this.counter = counter; };
        
    }
    
    ListNode recur(ListNode node, Counter C) {
        
        if (node == null) {
            
            C.counter--;
            return null; 
            
        }
        
        node.next = recur(node.next, C);
        
        if (C.counter == 0) {
            
            C.counter--;
            return node.next;
            
        }
        
        C.counter--;
        return node;
        
    }
    
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        Counter counter = new Counter(n);
        
        return recur(head, counter);
        
    }
}