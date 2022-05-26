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
        head.isWord = true;
    }

    public boolean search(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.childrens[c - 'a'] == null) {
                return false;
            }
            head = head.childrens[c - 'a'];
        }
        return head.isWord;
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
    boolean isWord;

    public Node() {
        childrens = new Node[26];
        isWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */