// https://leetcode.com/problems/odd-even-linked-list/

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

  public ListNode oddEvenList(ListNode head) {
    if (
      head == null || head.next == null || head.next.next == null
    ) return head;

    int count = 1;

    ListNode firstEven = head.next;

    ListNode curr = head;
    ListNode prev = null;
    ListNode next = null;

    while (curr.next != null) {
      count++;
      prev = curr;

      next = curr.next;

      curr.next = curr.next.next;

      curr = next;
    }

    if (count % 2 == 0) {
      prev.next = firstEven;
    } else {
      curr.next = firstEven;
    }

    return head;
  }
}
