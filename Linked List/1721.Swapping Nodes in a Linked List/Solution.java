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

    ListNode[] ans = new ListNode[2];

    public int dfs(ListNode node, int d, int k) {
        if (node == null) {
            return 1;
        }
        int h = dfs(node.next, d + 1, k);
        if (d == k) {
            ans[0] = node;
        }
        if (h == k) {
            ans[1] = node;
        }
        return h + 1;
    }

    public ListNode swapNodes(ListNode head, int k) {
        dfs(head, 1, k);
        int tmp = ans[0].val;
        ans[0].val = ans[1].val;
        ans[1].val = tmp;
        return head;
    }
}