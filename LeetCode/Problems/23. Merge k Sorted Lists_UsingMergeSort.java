// https://leetcode.com/problems/merge-k-sorted-lists/

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
    // Runtime: 107 ms, faster than  14.98% of Java online submissions for Merge k Sorted Lists.
    ListNode merge(ListNode head1, ListNode head2) {
        
        if (head1 == null && head2 == null) return null;
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        
        ListNode head = null;
        
        ListNode prev;
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        
        if (head1.val < head2.val) {
            
            head = head1;
            
            prev = head1;
            curr1 = curr1.next;
            
        } else {
            
            head = head2;
            
            prev = head2;
            curr2 = curr2.next;
        }
        
        
        while (curr1 != null && curr2 != null) {
            
            if (curr1.val < curr2.val) {
                
                prev.next = curr1;
                
                prev = curr1;
                curr1 = curr1.next;
                
            } else {
                
                prev.next = curr2;
                
                prev = curr2;
                curr2 = curr2.next;
                
            }
            
        }
        
        
        if (curr1 == null) {
            
            prev.next = curr2;
            
        } else  {
            
            prev.next = curr1;
            
        }
        
      
        return head;
        
    }
    
    ListNode mergeSort(ListNode lists[], int low, int high) {
        
        if (low == high) return lists[low];
        
        int mid = low + (high - low) / 2;
        
        ListNode head1 = mergeSort(lists, low, mid);
        ListNode head2 = mergeSort(lists, mid + 1, high);
        
        return merge(head1, head2);
        
    }
    
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists.length == 0) return null;
        
        if (lists.length == 1) return lists[0];
        
        return mergeSort(lists, 0, lists.length - 1);
        
    }
}