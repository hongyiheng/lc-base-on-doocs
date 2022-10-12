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
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            s.add(v);
        }
        while (head != null) {
            if (!s.contains(head.val)) {
                head = head.next;
                continue;
            }
            ListNode tmp = head;
            while (tmp != null && s.contains(tmp.val)) {
                tmp = tmp.next;
            }
            ans++;
            head = tmp;
        }
        return ans;
    }
}
