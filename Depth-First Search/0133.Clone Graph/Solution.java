/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}n
*/

class Solution {
    Map<Integer, Node> mp = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node ans = mp.getOrDefault(node.val, new Node());
        mp.put(node.val, ans);
        if (ans.val == 0) {
            ans.val = node.val;
            ArrayList<Node> neighbors = new ArrayList<>();
            for (Node v : node.neighbors) {
                neighbors.add(cloneGraph(v));
            }
            ans.neighbors = neighbors;
        }
        return ans;
    }
}