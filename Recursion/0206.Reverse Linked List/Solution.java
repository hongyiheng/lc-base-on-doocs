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
    Deque<Integer> q;

    public ListNode reverseList(ListNode head) {
        q = new ArrayDeque<>();
        dfs(head);
        return head;
    }

    public void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        q.offer(head.val);
        dfs(head.next);
        head.val = q.pollFirst();
    }
}