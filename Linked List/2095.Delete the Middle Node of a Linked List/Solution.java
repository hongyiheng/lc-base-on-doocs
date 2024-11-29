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
    public ListNode deleteMiddle(ListNode head) {
        int n = dfs(head);
        if (n == 1) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        for (int i = 0; i < n / 2 - 1; i++) {
            head = head.next;
        }
        if (head.next != null) {
            head.next = head.next.next;
        }
        return dummy.next;
    }

    public int dfs(ListNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root.next) + 1;
    }
}