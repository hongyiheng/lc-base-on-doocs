class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stk = new ArrayDeque<>();
        stk.addLast(root);
        while (!stk.isEmpty()) {
            Node cur = stk.pollLast();
            res.addFirst(cur.val);
            for (Node item : cur.children) {
                stk.addLast(item);
            }

        }
        return res;
    }
}