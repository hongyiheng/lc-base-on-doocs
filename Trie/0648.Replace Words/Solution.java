class Solution {
    Node root;

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Node();
        for (String w : dictionary) {
            insert(root, w);
        }
        String[] ws = sentence.split(" ");
        for (int i = 0; i < ws.length; i++) {
            ws[i] = getDic(root, ws[i]);
        }
        return String.join(" ", ws);
    }

    public void insert(Node root, String w) {
        Node head = root;
        for (char c : w.toCharArray()) {
            if (head.child[c - 'a'] == null) {
                head.child[c - 'a'] = new Node();
            }
            head = head.child[c - 'a'];
        }
        head.isWord = true;
    }

    public String getDic(Node root, String w) {
        String ans = "";
        Node head = root;
        for (char c : w.toCharArray()) {
            if (head.isWord) {
                return ans;
            }
            if (head.child[c - 'a'] == null) {
                break;
            }
            ans += c;
            head = head.child[c - 'a'];
        }
        return w;
    }

    class Node {
        Node[] child;
        boolean isWord;

        public Node() {
            this.child = new Node[26];
        }
    }
}