class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            vis[i][0] = true;
            q.addLast(new int[]{i, 0, grid[i][0]});
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1], v = cur[2];
                for (int d = -1; d <= 1; d++) {
                    int nx = x + d, ny = y + 1;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (vis[nx][ny] || grid[nx][ny] <= v) {
                        continue;
                    }
                    vis[nx][ny] = true;
                    q.addLast(new int[]{nx, ny, grid[nx][ny]});
                }
            }
            if (!q.isEmpty()) {
                ans++;
            }
        }
        return ans;
    }
}