class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{0, 0, 0});
        int[][] f = new int[m][n];
        for (int[] r : f) {
            Arrays.fill(r, 0x3f3f3f3f);
        }
        f[0][0] = 0;
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int w = e[0], x = e[1], y = e[2];
            if (f[x][y] != w) {
                continue;
            }
            for (int[] d : new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                int nw = Math.max(w, Math.abs(heights[nx][ny] - heights[x][y]));
                if (nw < f[nx][ny]) {
                    f[nx][ny] = nw;
                    q.add(new int[]{nw, nx, ny});
                }
            }
        }
        return f[m - 1][n - 1];
    }
}