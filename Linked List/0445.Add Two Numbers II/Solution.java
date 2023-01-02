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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> s1 = new ArrayList<>(), s2 = new ArrayList<>();
        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        int i = s1.size() - 1, j = s2.size() - 1, carry = 0;
        ListNode head = null;
        while (i >= 0 || j >= 0 || carry != 0) {
            int a = i >= 0 ? s1.get(i--) : 0;
            int b = j >= 0 ? s2.get(j--) : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }
        return head;
    }
}