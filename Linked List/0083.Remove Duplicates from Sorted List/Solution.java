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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode ans = head;
        int cur = head.val;
        while (head != null && head.next != null) {
            if (head.next.val == cur) {
                head.next = head.next.next;
                continue;
            }
            cur = head.next.val;
            head = head.next;
        }
        return ans;
    }
}