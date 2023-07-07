class Solution {
    public int longestIdealString(String s, int k) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            int v = c - 'a';
            f[v]++;
            for (int i = Math.max(0, v - k); i < Math.min(26, v + k + 1); i++) {
                if (i == v) {
                    continue;
                }
                f[v] = Math.max(f[v], f[i] + 1);
            }
        }
        int ans = 0;
        for (int v : f) {
            ans = Math.max(ans, v);
        }
        return ans;
    }
}