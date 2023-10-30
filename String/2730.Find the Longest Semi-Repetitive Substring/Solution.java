class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int ans = Math.min(1, n);
        for (int i = 0; i < n; i++) {
            char last = s.charAt(i);
            int k = -1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == last) {
                    if (++k > 0) {
                        ans = Math.max(ans, j - i);
                        break;
                    }
                }
                last = s.charAt(j);
            }
            if (k <= 0) {
                ans = Math.max(ans, n - i);
                break;
            }
        }
        return ans;
    }
}