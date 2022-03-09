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
    ListNode head;
    int deep;
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        deep = 0;
        this.head = head;
        link(head);
        int offset = deep - k % deep;
        while (offset-- > 1) {
            head = head.next;
        }
        ListNode ans = head.next;
        head.next = null;
        return ans;
    }

    public void link(ListNode root) {
        deep++;
        if (root.next == null) {
            root.next = head;
            return;
        }
        link(root.next);
    }
}