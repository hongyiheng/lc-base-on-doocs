class Trie {
    Trie[] children = new Trie[2];
    int cnt = 0;

    public void insert(int x) {
        Trie node = this;
        for (int i = 15; i >= 0; i--) {
            int v = x >> i & 1;
            if (node.children[v] == null) {
                node.children[v] = new Trie();
            }
            node = node.children[v];
            node.cnt++;
        }
    }

    public int search(int x, int mx) {
        Trie node = this;
        int ans = 0;
        for (int i = 15; i >= 0; i--) {
            if (node == null) {
                return ans;
            }
            int v = x >> i & 1;
            if ((mx >> i & 1) == 1) {
                if (node.children[v] != null) {
                    ans += node.children[v].cnt;
                }
                node = node.children[v ^ 1];
            } else {
                node = node.children[v];
            }
        }
        return ans;
    }
}

class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Trie tree = new Trie();
        int n = nums.length, ans = 0;
        for (int v : nums) {
            ans += tree.search(v, high + 1) - tree.search(v, low);
            tree.insert(v);
        }
        return ans;
    }
}