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
    public int pairSum(ListNode head) {
        Deque<Integer> q = new ArrayDeque<>();
        while (head != null) {
            q.addLast(head.val);
            head = head.next;
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int cur = q.pollFirst() + q.pollLast();
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}