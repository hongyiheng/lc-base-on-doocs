class Solution {
    public int longestPalindrome(String s) {
        int n = 'z' - 'A' + 1;
        int[] cnt = new int[n];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }
        int ans = 0;
        boolean extra = false;
        for (int v : cnt) {
            if (v % 2 != 0) {
                extra = true;
            }
            ans += v / 2 * 2;
        }
        return extra ? ans + 1 : ans;
    }
}
