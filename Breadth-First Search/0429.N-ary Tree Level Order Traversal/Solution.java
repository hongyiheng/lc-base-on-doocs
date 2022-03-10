/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<Node> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int m = q.size();
            List<Integer> row = new ArrayList<>();
            while (m-- > 0) {
                Node cur = q.pop();
                row.add(cur.val);
                for (Node child : cur.children) {
                    q.addLast(child);
                }
            }
            ans.add(row);
        }
        return ans;
    }
}