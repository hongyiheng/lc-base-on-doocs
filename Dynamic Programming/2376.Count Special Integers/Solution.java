class Solution {

    String s;
    int[][] f;

    public int countSpecialNumbers(int n) {
        s = String.valueOf(n);
        f = new int[s.length()][1 << 10];
        for (int[] r : f) {
            Arrays.fill(r, -1);
        }
        return dfs(0, 0, true, false);
    }

    public int dfs(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length()) {
            return isNum ? 1 : 0;
        }
        if (isNum && !isLimit && f[i][mask] != -1) {
            return f[i][mask];
        }
        int ans = 0;
        if (!isNum) {
            ans = dfs(i + 1, mask, false, false);
        }
        int low = isNum ? 0 : 1;
        int up = isLimit ? s.charAt(i) - '0' : 9;
        for (int d = low; d <= up; d++) {
            if ((mask >> d & 1) == 0) {
                ans += dfs(i + 1, mask | 1 << d, isLimit && d == up, true);
            }
        }
        f[i][mask] = ans;
        return ans;
    }
}