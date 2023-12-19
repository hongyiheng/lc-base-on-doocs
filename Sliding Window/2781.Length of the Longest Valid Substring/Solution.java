class Node {
    Node[] children;
    boolean end;

    public Node() {
        children = new Node[26];
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String s) {
        Node cur = root;
        for (int i = s.length() - 1; i > -1; i--) {
            int idx = s.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Node();
            }
            cur = cur.children[idx];
        }
        cur.end = true;
    }

    public boolean search(String s) {
        Node cur = root;
        for (int i = s.length() - 1; i > -1; i--) {
            int idx = s.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
            if (cur.end) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Trie tr = new Trie();
        for (String s : forbidden) {
            tr.insert(s);
        }
        int l = 0, r = 0, ans = 0;
        while (r < word.length()) {
            while (tr.search(word.substring(l, r + 1))) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}