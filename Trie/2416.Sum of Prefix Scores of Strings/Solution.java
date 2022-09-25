class Node {
    Node[] child;
    int val;

    public Node() {
        child = new Node[26];
        val = 0;
    }
}

class Solution {
    public void insert(Node root, String w) {
        Node head = root;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (head.child[idx] == null) {
                head.child[idx] = new Node();
            }
            head.child[idx].val++;
            head = head.child[idx];
        }
    }

    public int query(Node root, String w) {
        int ans = 0;
        Node head = root;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            ans += head.child[idx].val;
            head = head.child[idx];
        }
        return ans;
    }

    public int[] sumPrefixScores(String[] words) {
        Node root = new Node();
        for (String w : words) {
            insert(root, w);
        }
        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = query(root, words[i]);
        }
        return ans;
    }
}
