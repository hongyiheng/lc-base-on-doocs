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
        ListNode ans = new ListNode();
        ListNode tmp = ans;
        int cur = 0;
        while (head != null) {
            if (head.val == 0 && cur > 0) {
                tmp.next = new ListNode(cur);
                tmp = tmp.next;
                cur = 0;
            }
            cur += head.val;
            head = head.next;
        }
        return ans.next;
    }
}