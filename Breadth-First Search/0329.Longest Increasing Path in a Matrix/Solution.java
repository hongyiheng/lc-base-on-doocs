class Solution {
    int[][] matrix;
    int m, n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] dis;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dis = new int[m][n];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, search(i, j));
            }
        }
        return ans;
    }

    public int search(int a, int b) {
        dis[a][b] = dis[a][b] == Integer.MAX_VALUE ? 1 : dis[a][b];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{a, b});
        int ans = 1;
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (matrix[nx][ny] <= matrix[x][y]) {
                    continue;
                }
                if (dis[nx][ny] == Integer.MAX_VALUE || dis[nx][ny] < dis[x][y] + 1) {
                    dis[nx][ny] = dis[x][y] + 1;
                    ans = Math.max(ans, dis[nx][ny]);
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return ans;
    }
}