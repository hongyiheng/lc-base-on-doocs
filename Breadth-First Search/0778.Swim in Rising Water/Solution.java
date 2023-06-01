class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = grid.length;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][n];
        int[][] ans = new int[n][n];
        q.add(new int[]{0, 0});
        vis[0][0] = true;
        ans[0][0] = grid[0][0];
        while (!q.isEmpty()) {
            int[] cur = q.pop();
            int x = cur[0], y = cur[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                int w = Math.max(ans[x][y], grid[nx][ny]);
                if (vis[nx][ny] && ans[nx][ny] <= w) {
                    continue;
                }
                vis[nx][ny] = true;
                ans[nx][ny] = w;
                q.addLast(new int[]{nx, ny});
            }
        }
        return ans[n - 1][n - 1];
    }
}