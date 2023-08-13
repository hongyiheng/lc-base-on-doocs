class Solution {

    Map<String, Integer> f = new HashMap<>();
    int n;
    int[][] g;
    int inf = 0x3f3f3f3f;

    public int minFallingPathSum(int[][] grid) {
        n = grid.length;
        if (n == 1) {
            return grid[0][0];
        }
        g = grid;
        return dfs(0, -1);
    }

    public int dfs(int i, int j) {
        if (i == n) {
            return 0;
        }
        String key = i + ":" + j;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int a = inf, b = inf, aId = inf, bId = inf;
        for (int k = 0; k < n; k++) {
            if (k == j) {
                continue;
            }
            if (g[i][k] < a) {
                int t = a, tId = aId;
                a = g[i][k];
                aId = k;
                b = t;
                bId = tId;
            } else if (g[i][k] < b) {
                b = g[i][k];
                bId = k;
            }
        }
        int ans = Math.min(dfs(i + 1, aId) + a, dfs(i + 1, bId) + b);
        f.put(key, ans);
        return ans;
    }
}