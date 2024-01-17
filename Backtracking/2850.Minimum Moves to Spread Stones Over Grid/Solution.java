class Solution {

    int n = 3, inf = 0x3f3f3f3f;

    public int dfs(int i, int[] u, int v) {
        if (i == 9) {
            return v == 0 ? 0 : inf;
        }
        if ((v >> i & 1) == 0) {
            return dfs(i + 1, u, v);
        }
        int ans = inf;
        for (int j = 0; j < 9; j++) {
            if (u[j] == 0) {
                continue;
            }
            u[j]--;
            int cost = Math.abs(j / 3 - i / 3) + Math.abs(j % 3 - i % 3);
            ans = Math.min(ans, dfs(i + 1, u, v ^ (1 << i)) + cost);
            u[j]++;
        }
        return ans;
    }

    public int minimumMoves(int[][] grid) {
        int[] u = new int[9];
        int v = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    v |= (1 << (i * n + j));
                } else {
                    u[i * n + j] = grid[i][j] - 1;
                }
            }
        }
        return dfs(0, u, v);
    }
}