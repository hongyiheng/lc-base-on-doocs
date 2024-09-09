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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode t = dummy;
        int s = 0;
        while (head != null) {
            if (head.val == 0 && s != 0) {
                t.next = new ListNode(s);
                t = t.next;
                s = 0;
            }
            s += head.val;
            head = head.next;
        }
        return dummy.next;
    }
}