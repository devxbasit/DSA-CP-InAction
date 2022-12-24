/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if (head == null || head.next == null) return false;
        
        // floyd cyle detection / torotise and hare Algorithm
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        // check only for fast pointer
        
        // make sure next two node are not null
        
        while (fast.next != null && fast.next.next != null) {
         
            if (slow == fast) return true;
            
            slow = slow.next;
            
            fast = fast.next.next;
            
        }
        
        return false;

        // method 2 - mark visited nodes

        // ListNode node = head;
        
        // while (node != null) {
            
        //     if (node.val == Integer.MAX_VALUE) return true;
            
        //     node.val = Integer.MAX_VALUE;
        //     node = node.next;
            
        // }
        
        // return false;

        
    }
}