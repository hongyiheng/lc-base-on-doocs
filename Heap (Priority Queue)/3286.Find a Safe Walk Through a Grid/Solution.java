class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] f = new int[m][n];
        for (int[] r : f) {
            Arrays.fill(r, 0x3f3f3f3f);
        }
        f[0][0] = grid.get(0).get(0);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{f[0][0], 0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int w = cur[0], x = cur[1], y = cur[2];
            if (x == m - 1 && y == n - 1) {
                return w < health;
            }
            for (int[] d : new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}}) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (f[nx][ny] <= w + grid.get(nx).get(ny)) {
                    continue;
                }
                f[nx][ny] = w + grid.get(nx).get(ny);
                q.add(new int[]{f[nx][ny], nx, ny});
            }
        }
        return false;
    }
}