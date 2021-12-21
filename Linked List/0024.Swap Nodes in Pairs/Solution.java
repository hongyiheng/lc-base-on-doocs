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
    public ListNode swapPairs(ListNode head) {
        Deque<ListNode> stk = new ArrayDeque<>();
        ListNode temp = new ListNode();
        ListNode cur = head;
        head = temp;
        while (cur != null && cur.next != null) {
            stk.addFirst(cur);
            stk.addFirst(cur.next);
            cur = cur.next.next;
            temp.next = stk.pop();
            temp = temp.next;
            temp.next = stk.pop();
            temp = temp.next;
        }
        temp.next = cur;
        return head.next;
    }
}