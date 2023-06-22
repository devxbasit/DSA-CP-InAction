// https://leetcode.com/problems/sort-list/
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

  ListNode getMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  ListNode merge(ListNode head1, ListNode head2) {
    ListNode newHead;

    ListNode prev;
    ListNode curr1 = head1;
    ListNode curr2 = head2;

    if (head1.val < head2.val) {
      newHead = head1;

      prev = head1;
      curr1 = curr1.next;
    } else {
      newHead = head2;

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
    } else {
      prev.next = curr1;
    }

    return newHead;
  }

  ListNode mergesort(ListNode head) {
    if (head.next == null) return head;

    ListNode mid = getMid(head);

    ListNode head2 = mid.next;
    mid.next = null;

    ListNode newHead1 = mergesort(head);
    ListNode newHead2 = mergesort(head2);

    return merge(newHead1, newHead2);
  }

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    return mergesort(head);
  }
}
