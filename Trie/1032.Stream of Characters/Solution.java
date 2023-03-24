class StreamChecker {

    class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String s) {
            Node cur = root;
            for (int i = s.length() - 1; i > -1; i--) {
                char c = s.charAt(i);
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new Node();
                }
                cur = cur.child[c - 'a'];
            }
            cur.end = true;
        }

        public boolean search(String s) {
            Node cur = root;
            for (int i = s.length() - 1; i > -1; i--) {
                char c = s.charAt(i);
                if (cur.child[c - 'a'] == null) {
                    return false;
                }
                cur = cur.child[c - 'a'];
                if (cur.end) {
                    return true;
                }
            }
            return false;
        }
    }

    Trie tr;
    StringBuilder s;

    public StreamChecker(String[] words) {
        s = new StringBuilder();
        tr = new Trie();
        for (String word : words) {
            tr.insert(word);
        }
    }

    public boolean query(char letter) {
        s.append(letter);
        return tr.search(s.toString());
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
