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
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode();
        pre.next = head;
        dfs(pre, val);
        return pre.next;
    }

    public void dfs(ListNode root, int val) {
        if (root == null || root.next == null) {
            return;
        }
        if (root.next.val == val) {
            root.next = root.next.next;
            dfs(root, val);
        } else {
            dfs(root.next, val);
        }
    }
}