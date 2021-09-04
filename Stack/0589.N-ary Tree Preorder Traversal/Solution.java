class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stk = new ArrayDeque<>();
        stk.addLast(root);
        while (!stk.isEmpty()) {
            Node cur = stk.pollLast();
            res.add(cur.val);
            Collections.reverse(cur.children);
            for (Node item : cur.children) {
                stk.addLast(item);
            }
        }
        return res;
    }
}