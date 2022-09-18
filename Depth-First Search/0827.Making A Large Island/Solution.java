class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] grid;
    int n;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0, group = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    mp.put(group, dfs(i, j, group));
                    ans = Math.max(ans, mp.get(group));
                    group++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                int cur = 1;
                Set<Integer> used = new HashSet<>();
                used.add(0);
                used.add(1);
                for (int[] d : dirs) {
                    int nx = i + d[0], ny = j + d[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (used.contains(grid[nx][ny])) {
                        continue;
                    }
                    cur += mp.get(grid[nx][ny]);
                    used.add(grid[nx][ny]);
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int v) {
        if (grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = v;
        int ans = 1;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[nx][ny] == 1) {
                ans += dfs(nx, ny, v);
            }
        }
        return ans;
    }
}