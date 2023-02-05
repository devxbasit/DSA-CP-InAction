// https://leetcode.com/problems/reverse-linked-list/
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

    ListNode newHead = null;

    void recur(ListNode node, ListNode parent) {

        if (node.next == null) {

            newHead = node;

            node.next = parent;

            return;

        }

        recur(node.next, node);

        node.next = parent;

    }

    public ListNode reverseList(ListNode head) {

        if (head == null)
            return null;
        if (head.next == null)
            return head;

        recur(head, null);

        return newHead;

    }
}