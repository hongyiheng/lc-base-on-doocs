class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int ans = m * n;
        Deque<int[]> q = new ArrayDeque<>();
        Set<Integer> guardSet = new HashSet<>();
        Set<Integer> wallSet = new HashSet<>();
        for (int[] g : guards) {
            q.add(g);
            guardSet.add(g[0] * n + g[1]);
            ans--;
        }
        for (int[] w : walls) {
            wallSet.add(w[0] * n + w[1]);
            ans--;
        }
        int[][] vis = new int[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++) {
                int[] d = dirs[i];
                int nx = x, ny = y;
                while (true) {
                    nx += d[0];
                    ny += d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        break;
                    }
                    int idx = nx * n + ny;
                    if (wallSet.contains(idx) || guardSet.contains(idx)) {
                        break;
                    }
                    if ((vis[nx][ny] & (1 << i)) == 0) {
                        if (vis[nx][ny] == 0) {
                            ans--;
                        }
                        vis[nx][ny] |= 1 << i;
                    }
                }
            }
        }
        return ans;
    }
}