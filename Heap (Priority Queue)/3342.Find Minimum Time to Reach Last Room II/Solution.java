class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int[][] step = new int[m][n];
        for (int[] r : step) {
            Arrays.fill(r, 0x3f3f3f3f);
        }
        step[0][0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int w = e[0], x = e[1], y = e[2];
            if (x == m - 1 && y == n - 1) {
                return w;
            }
            int t = (x + y) % 2 + 1;
            for (int[] d : new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}}) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                int nw = Math.max(moveTime[nx][ny], w) + t;
                if (step[nx][ny] <= nw) {
                    continue;
                }
                step[nx][ny] = nw;
                q.add(new int[]{nw, nx, ny});
            }
        }
        return -1;
    }
}