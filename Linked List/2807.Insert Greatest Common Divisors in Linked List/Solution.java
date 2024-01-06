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

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public ListNode dfs(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode ne = node.next;
        ListNode mid = new ListNode(gcd(node.val, ne.val));
        node.next = mid;
        mid.next = dfs(ne);
        return node;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        return dfs(head);
    }
}