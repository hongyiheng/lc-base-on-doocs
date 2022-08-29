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
        ListNode ans = new ListNode();
        ListNode tmp = ans;
        int next = 0;
        while (l1 != null || l2 != null) {
            int cur = next;
            cur += l1 == null ? 0 : l1.val;
            cur += l2 == null ? 0 : l2.val;
            next = cur / 10;
            tmp.next = new ListNode(cur % 10);
            tmp = tmp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (next != 0) {
            tmp.next = new ListNode(next);
        }
        return ans.next;
    }
}