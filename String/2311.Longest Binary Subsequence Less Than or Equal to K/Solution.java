class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length(), ans = 0;
        for (int i = n - 1; i > -1; i--) {
            long x = 0, idx = 0;
            for (int j = i; j > -1; j--) {
                int v = s.charAt(j) - '0';
                if (v == 0) {
                    idx++;
                    continue;
                }
                if (idx > 32 || ((x | 1L << idx) > k)) {
                    continue;
                }
                x = x | 1L << idx;
                idx++;
            }
            ans = Math.max(ans, (int)idx);
        }
        return ans;
    }
}