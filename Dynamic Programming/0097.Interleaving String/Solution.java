class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), t = s3.length();
        if (m + n != t) {
            return false;
        }
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            f[i][0] = f[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j < n + 1; j++) {
            f[0][j] = f[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char c = s3.charAt(i + j - 1);
                if (f[i - 1][j] && s1.charAt(i - 1) == c) {
                    f[i][j] = true;
                }
                if (f[i][j - 1] && s2.charAt(j - 1) == c) {
                    f[i][j] = true;
                }
            }
        }
        return f[m][n];
    }
}