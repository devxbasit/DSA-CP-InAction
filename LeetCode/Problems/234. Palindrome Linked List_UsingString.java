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

  public boolean isPalindrome(ListNode head) {
    // method 1 - use stack push all node into stack,
    // traverse list again and pop from stack, and compare

    String S = "";
    ListNode node = head;

    while (node != null) {
      S += (char) node.val;

      node = node.next;
    }

    int i = 0;
    int j = S.length() - 1;

    while (i < j) {
      if (S.charAt(i) != S.charAt(j)) return false;

      i++;
      j--;
    }

    return true;
  }
}
