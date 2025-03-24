class Node {
    Node[] children;
    Integer end;

    public Node() {
        children = new Node[26];
        end = 0;
    }
}

class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String s) {
        Node node = root;
        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
        }
        node.end++;
    }

    public int search(String s) {
        int ans = 0;
        Node node = root;
        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                break;
            }
            node = node.children[c - 'a'];
            ans += node.end;
        }
        return ans;
    }
}


class Solution {
    public int countPrefixes(String[] words, String s) {
        Trie tr = new Trie();
        for (String w : words) {
            tr.insert(w);
        }
        return tr.search(s);
    }
}