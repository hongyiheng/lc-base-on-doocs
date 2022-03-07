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
    public ListNode sortLinkedList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.next.val < 0) {
                ListNode node = tmp.next;
                tmp.next = tmp.next.next;
                node.next = dummy.next;
                dummy.next = node;
            } else {
                tmp = tmp.next;
            }
        }
        return dummy.next;
    }
}