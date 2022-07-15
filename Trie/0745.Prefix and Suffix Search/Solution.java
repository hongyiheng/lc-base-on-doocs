class WordFilter {
    Node pre;
    Node tail;
    String[] words;

    public WordFilter(String[] words) {
        pre = new Node();
        tail = new Node();
        this.words = words;
        for (int i = 0; i < words.length; i++) {
            insert(i, false);
            insert(i, true);
        }
    }

    public int f(String pref, String suff) {
        List<Integer> preList = query(pref, false);
        List<Integer> tailList = query(suff, true);
        int i = preList.size() - 1, j = tailList.size() - 1;
        while (i >= 0 && j >= 0) {
            int a = preList.get(i), b = tailList.get(j);
            if (a == b) {
                return preList.get(i);
            } else if (a > b) {
                i--;
            } else {
                j--;
            }
        }
        return -1;
    }

    public void insert(int i, boolean desc) {
        Node head = pre;
        String w = words[i];
        if (desc) {
            head = tail;
            w = new StringBuilder(w).reverse().toString();
        }
        for (char c : w.toCharArray()) {
            if (head.child[c - 'a'] == null) {
                head.child[c - 'a'] = new Node();
            }
            head = head.child[c - 'a'];
            head.ids.add(i);
        }
    }

    public List<Integer> query(String w, boolean desc) {
        Node head = pre;
        if (desc) {
            head = tail;
            w = new StringBuilder(w).reverse().toString();
        }
        for (char c : w.toCharArray()) {
            if (head.child[c - 'a'] == null) {
                return new ArrayList<>();
            }
            head = head.child[c - 'a'];
        }
        return head.ids;
    }
}

class Node {
    List<Integer> ids;
    Node[] child;

    public Node() {
        ids = new ArrayList<>();
        child = new Node[26];
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */