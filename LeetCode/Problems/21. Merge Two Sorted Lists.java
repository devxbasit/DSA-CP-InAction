// https://leetcode.com/problems/merge-two-sorted-lists/
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

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;

    if (l2 == null) return l1;

    ListNode head = null;
    ListNode curr = null;
    ListNode list1 = l1;
    ListNode list2 = l2;

    if (l1.val < l2.val) {
      head = l1;
      curr = l1;

      list1 = l1.next;
    } else {
      head = l2;
      curr = l2;

      list2 = l2.next;
    }

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        curr.next = list1;

        curr = list1;

        list1 = list1.next;
      } else {
        curr.next = list2;

        curr = list2;

        list2 = list2.next;
      }
    }

    if (list1 == null) curr.next = list2;

    if (list2 == null) curr.next = list1;

    return head;
  }
}
