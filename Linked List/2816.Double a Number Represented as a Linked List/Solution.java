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

    public boolean dfs(ListNode head) {
        if (head == null) {
            return false;
        }
        boolean up = dfs(head.next);
        int v = up ? head.val * 2 + 1 : head.val * 2;
        head.val = v % 10;
        return v >= 10;
    }

    public ListNode doubleIt(ListNode head) {
        boolean up = dfs(head);
        return up ? new ListNode(1, head) : head;
    }
}