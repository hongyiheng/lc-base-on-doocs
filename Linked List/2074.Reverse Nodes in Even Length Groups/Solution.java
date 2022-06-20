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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> nums = new ArrayList<>();
        int n = 0;
        while (head != null) {
            nums.add(head.val);
            n++;
            head = head.next;
        }
        int idx = 0, cur = 1;
        List<Integer> newNums = new ArrayList<>();
        while (idx < n) {
            int r = Math.min(idx + cur, n);
            if ((r - idx) % 2 == 0) {
                for (int i = r - 1; i >= idx; i--) {
                    newNums.add(nums.get(i));
                }
            } else {
                for (int i = idx; i < r; i++) {
                    newNums.add(nums.get(i));
                }
            }
            idx = r;
            cur++;
        }
        ListNode dummy = new ListNode();
        ListNode tmp = dummy;
        for (int v : newNums) {
            tmp.next = new ListNode(v);
            tmp = tmp.next;
        }
        return dummy.next;
    }
}