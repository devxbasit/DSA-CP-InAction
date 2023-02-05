// https://leetcode.com/problems/two-sum/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = l1.val + l2.val;

        ListNode prev = new ListNode(sum % 10);

        ListNode head = prev;

        int carry = sum / 10;

        sum = 0;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {

            sum = l1.val + l2.val + carry;

            ListNode node = new ListNode(sum % 10);

            carry = sum / 10;

            prev.next = node;

            prev = node;

            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null) {

            sum = l1.val + carry;

            ListNode node = new ListNode(sum % 10);

            carry = sum / 10;

            prev.next = node;

            prev = node;
            l1 = l1.next;

        }

        while (l2 != null) {

            // System.out.println("l2 " + prev.val + " "+carry +" " + l2.val);
            sum = l2.val + carry;

            ListNode node = new ListNode(sum % 10);

            carry = sum / 10;

            prev.next = node;

            prev = node;
            l2 = l2.next;

        }

        if (carry != 0) {

            ListNode c = new ListNode(carry);

            prev.next = c;

        }

        return head;

    }
}