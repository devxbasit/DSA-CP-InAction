// https://leetcode.com/problems/intersection-of-two-linked-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int n1 = 0;
    int n2 = 0;

    ListNode temp = headA;

    while (temp != null) {
      n1++;
      temp = temp.next;
    }

    temp = headB;
    while (temp != null) {
      n2++;
      temp = temp.next;
    }

    int diff = Math.abs(n1 - n2);

    ListNode node1 = headA;
    ListNode node2 = headB;

    if (n1 > n2) {
      while (diff-- > 0) node1 = node1.next;
    } else {
      while (diff-- > 0) node2 = node2.next;
    }

    while (node1 != node2) {
      node1 = node1.next;
      node2 = node2.next;
    }

    return node1;
  }
}
