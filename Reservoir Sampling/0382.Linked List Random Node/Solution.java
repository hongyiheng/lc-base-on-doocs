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
    ListNode head;
    Random r = new Random(20220116);
    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int ans = 0, i = 0;
        ListNode t = head;
        while (t != null) {
            if (r.nextInt(++i) == 0) {
                ans = t.val;
            }
            t = t.next;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */