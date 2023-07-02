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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tmp = dummy;
        boolean carry = false;
        while (l1 != null || l2 != null) {
            int v = carry ? 1 : 0;
            if (l1 != null) {
                v += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v += l2.val;
                l2 = l2.next;
            }
            carry = v >= 10;
            tmp.next = new ListNode(v % 10);
            tmp = tmp.next;
        }
        if (carry) {
            tmp.next = new ListNode(1);
        }
        return dummy.next;
    }
}