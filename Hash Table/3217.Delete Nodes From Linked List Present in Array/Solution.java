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

    Set<Integer> s;

    public ListNode dfs(ListNode node) {
        if (node == null) {
            return null;
        }
        if (s.contains(node.val)) {
            return dfs(node.next);
        }
        node.next = dfs(node.next);
        return node;
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        s = new HashSet<>();
        for (int v : nums) {
            s.add(v);
        }
        return dfs(head);
    }
}