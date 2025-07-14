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

    int ans;

    public int dfs(ListNode head) {
        if (head == null) {
            return 0;
        }
        int d = dfs(head.next);
        ans = ans | (head.val << d);
        return d + 1;
    }

    public int getDecimalValue(ListNode head) {
        ans = 0;
        dfs(head);
        return ans;
    }
}