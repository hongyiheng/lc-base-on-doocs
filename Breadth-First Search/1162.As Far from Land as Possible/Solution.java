class Solution {
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] g;
    public int maxDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        g = grid;
        int ans = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }
        return ans;
    }

    public int bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        vis[x][y] = true;
        q.addLast(new int[]{x, y});
        int step = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            step++;
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                for (int[] d : dirs) {
                    int nx = cur[0] + d[0], ny = cur[1] + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) {
                        continue;
                    }
                    if (g[nx][ny] == 1) {
                        return step;
                    }
                    vis[nx][ny] = true;
                    q.addLast(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}