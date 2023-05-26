class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0});
        vis[0][0] = true;
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int ans = 1;
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1];
                if (x == m - 1 && y == n - 1) {
                    return ans;
                }
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] != 0 || vis[nx][ny]) {
                        continue;
                    }
                    q.addLast(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}
