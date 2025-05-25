class Solution {
    public int longestPalindrome(String[] words) {
        int[][] g = new int[26][26];
        int ans = 0;
        for (String w : words) {
            int i = w.charAt(0) - 'a', j = w.charAt(1) - 'a';
            if (g[j][i] > 0) {
                g[j][i]--;
                ans += 4;
            } else {
                g[i][j]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (g[i][i] > 0) {
                return ans + 2;
            }
        }
        return ans;
    }
}