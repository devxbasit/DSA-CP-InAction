// https://leetcode.com/problems/palindrome-linked-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    ListNode reverse(ListNode head) {

        if (head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {

            next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;

        }

        return prev;

    }

    boolean isPalindrome(ListNode head, ListNode tail) {

        if (head.next == null && tail.next == null)
            return head.val == tail.val;

        ListNode h = head;
        ListNode t = tail;

        // loop on tail node, not on head
        // e.g if total node are 11 , head will hold 6 node and tail 5
        // loop only on 5 node
        while (t != null) {

            if (h.val != t.val)
                return false;

            h = h.next;
            t = t.next;

        }

        return true;

    }

    public boolean isPalindrome(ListNode head) {

        if (head.next == null)
            return true;

        ListNode mid = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {

            mid = mid.next;

            fast = fast.next.next;
        }

        // reverse half part, and get tail node;
        ListNode tail = reverse(mid.next);

        // split into two lists
        mid.next = null;

        boolean isP = isPalindrome(head, tail);

        // again reverse and get back mid + 1 th node
        tail = reverse(tail);

        // fix broken link
        mid.next = tail;

        return isP;

    }
}