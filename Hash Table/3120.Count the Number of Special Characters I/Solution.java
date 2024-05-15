class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[][] cnt = new boolean[26][2];
        for (char c : word.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                int v = c - 'a';
                cnt[v][0] = true;
            } else {
                int v = c - 'A';
                cnt[v][1] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i][0] && cnt[i][1]) {
                ans++;
            }
        }
        return ans;
    }
}