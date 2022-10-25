class Solution {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    Deque<int[]> q = new ArrayDeque<>();
    int n;

    public void dfs(int[][] g, int x, int y) {
        if (g[x][y] != 1) {
            return;
        }
        q.addLast(new int[]{x, y});
        g[x][y] = 2;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            dfs(g, nx, ny);
        }
    }

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        for (int i = 0; i < n; i++) {
            boolean end = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    end = true;
                    break;
                }
            }
            if (end) {
                break;
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1];
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] == 1) {
                        return ans;
                    }
                    if (grid[nx][ny] == 0) {
                        grid[nx][ny] = 2;
                        q.addLast(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}
