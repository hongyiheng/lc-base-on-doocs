class Node {
    Node[] children;
    boolean end;

    public Node() {
        children = new Node[26];
        end = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String s) {
        Node node = root;
        for (int i = s.length() - 1; i > -1; i--) {
            int idx = s.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            node = node.children[idx];
        }
        node.end = true;
    }

    public boolean search(String s) {
        Node node = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return node.end;
    }
}


class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        Trie tr = new Trie();
        for (String w : words) {
            if (tr.search(w)) {
                ans++;
            }
            tr.insert(w);
        }
        return ans;
    }
}