class Solution {
    int m, n;
    int[][] grid;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maximumMinutes(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int left = 0, right = m * n;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (left == m * n) {
            return (int)1e9;
        }
        return check(left) ? left : -1;
    }

    public boolean check(int t) {
        boolean[][] fire = new boolean[m][n];
        List<int[]> curFire = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fire[i][j] = true;
                    curFire.add(new int[]{i, j});
                }
            }
        }
        while (t-- > 0) {
            curFire = infect(fire, curFire);
        }
        if (fire[0][0]) {
            return false;
        }
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0});
        vis[0][0] = true;
        while (!q.isEmpty()) {
            if (fire[m - 1][n - 1]) {
                return false;
            }
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1];
                if (fire[x][y]) {
                    continue;
                }
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (vis[nx][ny] || fire[nx][ny] || grid[nx][ny] == 2) {
                        continue;
                    }
                    if (nx == m - 1 && ny == n - 1) {
                        return true;
                    }
                    vis[nx][ny] = true;
                    q.addLast(new int[]{nx, ny});
                }
            }
            curFire = infect(fire, curFire);
        }
        return false;
    }

    public List<int[]> infect(boolean[][] fire, List<int[]> f) {
        List<int[]> next = new ArrayList<>();
        for (int[] v : f) {
            int x = v[0], y = v[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (fire[nx][ny] || grid[nx][ny] == 2) {
                    continue;
                }
                fire[nx][ny] = true;
                next.add(new int[]{nx, ny});
            }
        }
        return next;
    }
}