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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        Map<Integer, ListNode> mp = new HashMap<>();
        int cur = 0;
        while (p != null) {
            cur += p.val;
            mp.put(cur, p);
            p = p.next;
        }
        cur = 0;
        p = dummy;
        while (p != null) {
            cur += p.val;
            p.next = mp.get(cur).next;
            p = p.next;
        }
        return dummy.next;
    }
}