class Solution {

    int m, n;
    List<int[]> fires;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean check(int k, int[][] g) {
        Deque<int[]> q = new ArrayDeque<>(fires);
        Deque<int[]> p = new ArrayDeque<>();
        p.add(new int[]{0, 0});
        Set<Integer> vis = new HashSet<>();
        while (!p.isEmpty()) {
            if (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int x = q.peekFirst()[0], y = q.pollFirst()[1];
                    if (x == m - 1 && y == n - 1) {
                        return false;
                    }
                    for (int[] d : dirs) {
                        int nx = x + d[0], ny = y + d[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            continue;
                        }
                        if (vis.contains(nx * n + ny) || g[nx][ny] != 0) {
                            continue;
                        }
                        vis.add(nx * n + ny);
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            if (k <= 0) {
                int size = p.size();
                for (int i = 0; i < size; i++) {
                    int x = p.peekFirst()[0], y = p.pollFirst()[1];
                    for (int[] d : dirs) {
                        int nx = x + d[0], ny = y + d[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            continue;
                        }
                        if (nx == m - 1 && ny == n - 1) {
                            return true;
                        }
                        if (vis.contains(nx * n + ny) || g[nx][ny] != 0) {
                            continue;
                        }
                        vis.add(nx * n + ny);
                        p.add(new int[]{nx, ny});
                    }
                }
            }
            k--;
        }
        return false;
    }

    public int maximumMinutes(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        fires = new ArrayList<>();
        if (grid[m - 1][n - 1] != 0) {
            return -1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fires.add(new int[]{i, j});
                }
            }
        }
        if (!check(0, grid)) {
            return -1;
        }
        int l = 0, r = m * n + 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid, grid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r > m * n ? (int)1e9 : r;
    }

}