class Solution {
    int[][] grid;
    Map<Integer, Long> mp;
    int m, n;
    int mod = (int)1e9 + 7;

    public int countPaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        mp = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mp.containsKey(i * n + j)) {
                    ans = (ans + mp.get(i * n + j)) % mod;
                } else {
                    ans = (ans + dfs(i, j)) % mod;
                }
            }
        }
        return (int)(ans % mod);
    }

    public long dfs(int x, int y) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        long ans = 1;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[nx][ny] <= grid[x][y]) {
                continue;
            }
            if (!mp.containsKey(nx * n + ny)) {
                mp.put(nx * n + ny, dfs(nx, ny));
            }
            ans += mp.get(nx * n + ny);
        }
        ans %= mod;
        mp.put(x * n + y, ans);
        return ans;
    }
}