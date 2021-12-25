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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(), even = new ListNode();
        ListNode o = odd, e = even;
        int index = 1;
        while (head != null) {
            if (index++ % 2 == 0) {
                e.next = head;
                e = e.next;
            } else {
                o.next = head;
                o = o.next;
            }
            head = head.next;
        }
        e.next = null;
        o.next = even.next;
        return odd.next;
    }
}