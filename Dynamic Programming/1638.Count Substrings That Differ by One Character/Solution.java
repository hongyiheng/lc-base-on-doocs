class Solution {
    public int countSubstrings(String s, String t) {
        int n = s.length(), m = t.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int w = 0, diff = 0;
                while (i + w < n && j + w < m && diff <= 1) {
                    if (s.charAt(i + w) != t.charAt(j + w)) {
                        diff++;
                    }
                    if (diff == 1) {
                        ans++;
                    }
                    w++;
                }
            }
        }
        return ans;
    }
}