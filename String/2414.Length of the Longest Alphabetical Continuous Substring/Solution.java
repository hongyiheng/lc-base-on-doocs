class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 0, start = 0, n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if (cs[i] - cs[i - 1] == 1) {
                continue;
            }
            ans = Math.max(ans, i - start);
            start = i;
        }
        return Math.max(ans, n - start);
    }
}
