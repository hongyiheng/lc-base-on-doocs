class Solution {
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] g;
    Deque<int[]> q;
    int ans = -1;
    public int maxDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        g = grid;
        q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.addLast(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1];
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || g[nx][ny] != 0) {
                        continue;
                    }
                    g[nx][ny] = g[x][y] + 1;
                    q.addLast(new int[]{nx, ny});
                    ans = Math.max(ans, g[nx][ny] - 1);
                }
            }
        }
        return ans;
    }
}