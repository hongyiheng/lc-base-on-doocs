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
        if (k == 1) {
            return head;
        }
        ListNode tail = head, tmp = head;
        Deque<Integer> vals = new ArrayDeque<>();
        int cnt = 0;
        while (tail != null) {
            vals.addLast(tail.val);
            if (++cnt == k) {
                while (!vals.isEmpty()) {
                    tmp.val = vals.pollLast();
                    tmp = tmp.next;
                }
                cnt = 0;
                tmp = tail.next;
            }
            tail = tail.next;
        }
        return head;
    }
}