class Solution {
    public String shortestCommonSupersequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                ans.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (f[i - 1][j] > f[i][j - 1]) {
                ans.append(s.charAt(i - 1));
                i--;
            } else {
                ans.append(t.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            ans.append(s.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(t.charAt(j - 1));
            j--;
        }
        return ans.reverse().toString();
    }
}