class Solution {
    public int findLUSlength(String[] strs) {
        int ans = -1, n = strs.length;
        for (int i = 0; i < n; i++) {
            if (strs[i].length() < ans) {
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (check(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = strs[i].length();
            }
        }
        return ans;
    }

    public boolean check(String a, String b) {
        int m = a.length(), n = b.length();
        if (m > n) {
            return false;
        }
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
                f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                if (f[i][j] == m) {
                    return true;
                }
            }
        }
        return false;
    }
}