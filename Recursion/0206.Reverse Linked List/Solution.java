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

    public ListNode dfs(ListNode node, ListNode pre) {
        if (node == null) {
            return pre;
        }
        ListNode nx = node.next;
        node.next = pre;
        return dfs(nx, node);
    }

    public ListNode reverseList(ListNode head) {
        return dfs(head, null);
    }
}