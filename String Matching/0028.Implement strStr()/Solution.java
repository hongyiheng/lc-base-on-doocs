class Solution {
    public int strStr(String haystack, String needle) {
        KMP p = new KMP(needle);
        return p.search(haystack);
    }
}

public class KMP {
    int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int m = pat.length();
        dp = new int[m][256];
        dp[0][pat.charAt(0)] = 1;
        int x = 0;
        for (int j = 1; j < m; j++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(j) == c) {
                    dp[j][c] = j + 1;
                } else {
                    dp[j][c] = dp[x][c];
                }
            }
            x = dp[x][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        int m = pat.length(), n = txt.length();
        int j = 0;
        for (int i = 0; i < n; i++) {
            j = dp[j][txt.charAt(i)];
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}