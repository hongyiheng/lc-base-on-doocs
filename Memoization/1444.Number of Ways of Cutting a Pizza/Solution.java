class Solution {

    int m, n, mod;
    int[][] s;
    Map<String, Integer> f;

    public int dfs(int x, int y, int k) {
        String key = x + "_" + y + "_" + k;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int cur = s[m][n] - s[x][n] - s[m][y] + s[x][y];
        if (k == 0) {
            return cur > 0 ? 1 : 0;
        }
        int ans = 0;
        for (int i = x + 1; i < m + 1; i++) {
            int v = s[m][n] - s[i][n] - s[m][y] + s[i][y];
            if (cur > v) {
                ans = (ans + dfs(i, y, k - 1)) % mod;
            }
        }
        for (int j = y + 1; j < n + 1; j++) {
            int v = s[m][n] - s[x][n] - s[m][j] + s[x][j];
            if (cur > v) {
                ans = (ans + dfs(x, j, k - 1)) % mod;
            }
        }
        f.put(key, ans);
        return ans;
    }

    public int ways(String[] pizza, int k) {
        m = pizza.length;
        n = pizza[0].length();
        mod = (int) 1e9 + 7;
        s = new int[m + 1][n + 1];
        f = new HashMap<>();
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + (pizza[i - 1].charAt(j - 1) == 'A' ? 1 : 0);
            }
        }
        return dfs(0, 0, k - 1);
    }
}