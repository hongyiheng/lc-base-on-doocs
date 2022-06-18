/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node t = new Node(insertVal);
        t.next = t;
        if (head == null) {
            return t;
        }
        Node ans = head;
        int minVal = ans.val, maxVal = ans.val;
        while (head.next != ans) {
            head = head.next;
            maxVal = Math.max(maxVal, head.val);
            minVal = Math.min(minVal, head.val);
        }
        if (maxVal == minVal) {
            t.next = head.next;
            head.next = t;
            return ans;
        }
        while (head.val != maxVal && head.next.val != minVal) {
            head = head.next;
        }
        if (insertVal <= minVal || insertVal >= maxVal) {
            t.next = head.next;
            head.next = t;
        } else {
            while (head.val > insertVal || head.next.val < insertVal) {
                head = head.next;
            }
            t.next = head.next;
            head.next = t;
        }
        return ans;
    }
}