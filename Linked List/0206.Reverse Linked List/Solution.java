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
    ListNode node;

    public ListNode reverseList(ListNode head) {
        node = new ListNode();
        ListNode ans = node;
        dfs(head);
        return ans.next;
    }

    public void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        if (head.next != null) {
            dfs(head.next);
        }
        node.next = new ListNode(head.val);
        node = node.next;
    }
}