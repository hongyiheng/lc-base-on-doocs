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
        return dfs(l1, l2, false);
    }

    public ListNode dfs(ListNode l1, ListNode l2, boolean carry) {
        if (l1 == null && l2 == null) {
            return carry ? new ListNode(1) : null;
        }
        if (l1 == null) {
            l1 = l2;
            l2 = null;
        }
        int v = carry ? 1 : 0;
        v += l1.val;
        v += l2 == null ? 0 : l2.val;
        l1.val = v % 10;
        l1.next = dfs(l1.next, l2 == null ? null : l2.next, v >= 10);
        return l1;
    }
}