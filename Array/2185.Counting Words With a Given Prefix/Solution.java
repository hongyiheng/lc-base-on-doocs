class Solution {

    public int prefixCount(String[] words, String pref) {
        Node root = new Node();
        insert(root, pref);
        int ans = 0;
        for (String w : words) {
            if (w.length() < pref.length()) {
                continue;
            }
            if (startWith(root, w)) {
                ans++;
            }
        }
        return ans;
    }

    public void insert(Node root, String w) {
        Node head = root;
        for (char c : w.toCharArray()) {
            if (head.children[c - 'a'] == null) {
                head.children[c - 'a'] = new Node();
            }
            head = head.children[c - 'a'];
        }
    }

    public boolean startWith(Node root, String w) {
        Node head = root;
        for (char c : w.toCharArray()) {
            if (head.children[c - 'a'] == null) {
                for (int i = 0; i < 26; i++) {
                    if (head.children[i] != null) {
                        return false;
                    }
                }
                return true;
            }
            head = head.children[c - 'a'];
        }
        return true;
    }


}

class Node {
    Node[] children;

    public Node() {
        children = new Node[26];
    }
}