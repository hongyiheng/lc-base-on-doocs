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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (head != null) {
            Deque<ListNode> q = new ArrayDeque<>();
            int cnt = k;
            while (head != null && cnt > 0) {
                q.addLast(head);
                head = head.next;
                cnt--;
            }
            if (cnt > 0) {
                while (!q.isEmpty()) {
                    cur.next = q.pollFirst();
                    cur = cur.next;
                }
            } else {
                while (!q.isEmpty()) {
                    cur.next = q.pollLast();
                    cur = cur.next;
                }
            }
            if (head == null) {
                cur.next = null;
            }
        }
        return dummy.next;
    }
}