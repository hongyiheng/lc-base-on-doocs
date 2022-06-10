class Solution {
    public int countPrefixes(String[] words, String s) {
        Trie tr = new Trie();
        tr.insert(s);
        int ans = 0;
        for (String w : words) {
            if (tr.startsWith(w)) {
                ans++;
            }
        }
        return ans;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.childrens[c - 'a'] == null) {
                head.childrens[c - 'a'] = new Node();
            }
            head = head.childrens[c - 'a'];
        }
    }

    public boolean startsWith(String prefix) {
        Node head = root;
        for (char c : prefix.toCharArray()) {
            if (head.childrens[c - 'a'] == null) {
                return false;
            }
            head = head.childrens[c - 'a'];
        }
        return true;
    }
}

class Node {
    Node[] childrens;

    public Node() {
        childrens = new Node[26];
    }
}