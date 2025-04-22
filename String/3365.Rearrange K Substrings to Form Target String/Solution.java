class Node {
    Node[] children = new Node[26];
    int cnt = 0;
}

class Trie {
    Node root = new Node();

    public void insert(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.children[c - 'a'] == null) {
                head.children[c - 'a'] = new Node();
            }
            head = head.children[c - 'a'];
        }
        head.cnt++;
    }

    public boolean search(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.children[c - 'a'] == null) {
                return false;
            }
            head = head.children[c - 'a'];
        }
        if (head.cnt > 0) {
            head.cnt--;
            return true;
        }
        return false;
    }
}


class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();
        Trie tr = new Trie();
        int d = n / k;
        for (int i = 0; i < k; i++) {
            String w = s.substring(i * d, (i + 1) * d);
            tr.insert(w);
        }
        for (int i = 0; i < k; i++) {
            String w = t.substring(i * d, (i + 1) * d);
            if (!tr.search(w)) {
                return false;
            }
        }
        return true;
    }
}