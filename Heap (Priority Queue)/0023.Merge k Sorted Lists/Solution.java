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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        PriorityQueue<Pair<Integer, ListNode>> q = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        for (ListNode node : lists) {
            if (node != null) {
                q.add(new Pair<>(node.val, node));
            }
        }
        while (true) {
            ListNode minRoot = null;
            if (!q.isEmpty()) {
                minRoot = q.poll().getValue();
            }
            if (minRoot == null) {
                break;
            }
            tail.next = new ListNode(minRoot.val);
            tail = tail.next;
            minRoot = minRoot.next;
            if (minRoot != null) {
                q.add(new Pair<>(minRoot.val, minRoot));
            }
        }
        return dummy.next;
    }
}