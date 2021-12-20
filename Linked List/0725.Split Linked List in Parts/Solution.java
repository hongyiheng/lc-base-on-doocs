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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode dummp = new ListNode();
        dummp.next = head;
        int n = getLen(dummp.next, 0);
        ListNode[] ans = new ListNode[k];
        int num = n / k;
        int extra = n % k;
        for (int i = 0; i < k; i++) {
            if (n-- > 0) {
                int sonLen = extra-- <= 0 ? num : num + 1;
                ListNode cur = new ListNode();
                cur.next = head;
                while (sonLen-- > 1 && head != null) {
                    head = head.next;
                }
                ListNode temp = new ListNode();
                if (head != null) {
                    temp.next = head.next;
                    head.next = null;
                }
                head = temp.next;
                ans[i] = cur.next;
            }
        }
        return ans;
    }

    public int getLen(ListNode node, int len) {
        if (node == null) {
            return len;
        }
        return getLen(node.next, len + 1);
    }
}