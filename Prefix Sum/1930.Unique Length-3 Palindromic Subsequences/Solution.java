class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] pre = new int[26], tail = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            tail[c - 'a']++;
        }
        boolean[][] vis = new boolean[26][26];
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            int idx = cs[i] - 'a';
            tail[idx]--;
            for (int j = 0; j < 26; j++) {
                if (vis[idx][j]) {
                    continue;
                }
                if (pre[j] <= 0 || tail[j] <= 0) {
                    continue;
                }
                ans++;
                vis[idx][j] = true;
            }
            pre[idx]++;
        }
        return ans;
    }
}
