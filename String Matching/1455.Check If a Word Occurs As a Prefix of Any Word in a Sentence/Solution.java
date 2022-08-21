class Node {
    Node[] child;
    boolean end;

    public Node() {
        this.child = new Node[26];
        this.end = false;
    }
}

class Solution {
    Node root;

    public void insert(String w) {
        Node head = root;
        for (char c : w.toCharArray()) {
            if (head.child[c - 'a'] == null) {
                head.child[c - 'a'] = new Node();
            }
            head = head.child[c - 'a'];
        }
        head.end = true;
    }

    public boolean prefix(String w) {
        Node head = root;
        for (char c : w.toCharArray()) {
            if (head.child[c - 'a'] == null) {
                break;
            }
            head = head.child[c - 'a'];
        }
        return head.end;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        root = new Node();
        insert(searchWord);
        String[] ss = sentence.split(" ");
        for (int i = 0; i < ss.length; i++) {
            if (prefix(ss[i])) {
                return i + 1;
            }
        }
        return -1;
    }
}