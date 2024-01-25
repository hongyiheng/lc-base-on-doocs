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
    public boolean isPalindrome(ListNode head) {
        List<Integer> q = new ArrayList<>();
        while (head != null) {
            q.add(head.val);
            head = head.next;
        }
        int l = 0, r = q.size() - 1;
        while (l < r) {
            if (q.get(l) != q.get(r)) {
                break;
            }
            l++;
            r--;
        }
        return l >= r;
    }
}