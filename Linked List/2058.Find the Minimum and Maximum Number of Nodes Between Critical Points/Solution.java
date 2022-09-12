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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int f = 0, s = 0, idx = 1;
        int firstIdx = -1, lastIdx = -1;
        int minDis = Integer.MAX_VALUE, maxDis = Integer.MIN_VALUE;
        while (head != null) {
            if (f == 0) {
                f = head.val;
            } else if (s == 0) {
                s = head.val;
            } else {
                if ((f > s && s < head.val) || (f < s && s > head.val)) {
                    if (firstIdx == -1) {
                        firstIdx = idx - 1;
                    }
                    if (lastIdx != -1) {
                        minDis = Math.min(minDis, Math.abs(lastIdx - idx + 1));
                        maxDis = Math.max(maxDis, Math.abs(firstIdx - idx + 1));
                    }
                    lastIdx = idx - 1;
                }
                f = s;
                s = head.val;
            }
            head = head.next;
            idx++;
        }
        return minDis == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[]{minDis, maxDis};
    }
}