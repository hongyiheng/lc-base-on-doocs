class Trie {

    Trie[] children = new Trie[26];

    void insert(String w) {
        Trie node = this;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
    }
}

class Solution {

    int[] f;
    char[] cs;
    Trie tr;
    int inf = 0x3f3f3f3f, n = 0;

    public int minValidStrings(String[] words, String target) {
        tr = new Trie();
        for (String w : words) {
            tr.insert(w);
        }
        n = target.length();
        f = new int[n];
        Arrays.fill(f, -1);
        cs = target.toCharArray();
        int ans = dfs(0);
        return ans < inf ? ans : -1;
    }

    int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != -1) {
            return f[i];
        }
        Trie node = tr;
        f[i] = inf;
        for (int j = i; j < n; ++j) {
            int idx = cs[j] - 'a';
            if (node.children[idx] == null) {
                break;
            }
            f[i] = Math.min(f[i], dfs(j + 1) + 1);
            node = node.children[idx];
        }
        return f[i];
    }
}