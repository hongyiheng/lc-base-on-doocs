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
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode();
        while (head != null && head.val == val) {
            head = head.next;
        }
        ans = head;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                continue;
            }
            head = head.next;
        }
        return ans;
    }
}