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
    public int[] nextLargerNodes(ListNode head) {
        Deque<int[]> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        while (head != null) {
            while (!q.isEmpty() && q.peekLast()[1] < head.val) {
                int[] tmp = q.pollLast();
                ans.set(tmp[0], head.val);
            }
            q.add(new int[]{idx, head.val});
            ans.add(0);
            head = head.next;
            idx++;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
