class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length(), ans = 0;
        for (int i = n - 1; i > -1; i--) {
            long v = 0, l = 0;
            for (int j = i; j > -1; j--) {
                if (l > 32 && s.charAt(j) == '1') {
                    continue;
                }
                if (s.charAt(j) == '1' && v + (1L << l) > k) {
                    continue;
                } else if (s.charAt(j) == '1') {
                    v += (1L << l);
                }
                l++;
            }
            ans = Math.max(ans, (int) l);
        }
        return ans;
    }
}