class Solution {
    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int x = 0, y = 0, tx = 0, ty = 0, sx = 0, sy = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                } else if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 'B') {
                    x = i;
                    y = j;
                }
            }
        }
        Set<String> vis = new HashSet<>();
        Deque<int[]> q = new ArrayDeque<>();
        vis.add(x + "," + y + "," + sx + "," + sy);
        q.addLast(new int[]{x, y, sx, sy});
        int ans = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                x = cur[0];
                y = cur[1];
                sx = cur[2];
                sy = cur[3];
                if (x == tx && y == ty) {
                    return ans;
                }
                List<int[]> next = getNext(x, y, sx, sy, grid);
                for (int[] p : next) {
                    int nx = p[0], ny = p[1], nsx = p[2], nsy = p[3];
                    if (!vis.contains(nx + "," + ny + "," + nsx + "," + nsy)) {
                        vis.add(nx + "," + ny + "," + nsx + "," + nsy);
                        q.addLast(new int[]{nx, ny, nsx, nsy});
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private List<int[]> getNext(int x, int y, int sx, int sy, char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Set<String> vis = new HashSet<>();
        Deque<int[]> q = new ArrayDeque<>();
        vis.add(sx + "," + sy);
        q.addLast(new int[]{sx, sy});
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            sx = cur[0];
            sy = cur[1];
            for (int[] dir : dirs) {
                int nsx = sx + dir[0];
                int nsy = sy + dir[1];
                if (nsx < 0 || nsx >= m || nsy < 0 || nsy >= n || grid[nsx][nsy] == '#') {
                    continue;
                }
                if (vis.contains(nsx + "," + nsy)) {
                    continue;
                }
                if (nsx == x && nsy == y) {
                    continue;
                }
                vis.add(nsx + "," + nsy);
                q.addLast(new int[]{nsx, nsy});
            }
        }
        List<int[]> ans = new ArrayList<>();
        if (x + 1 < m && x - 1 >= 0 && grid[x + 1][y] != '#' && grid[x - 1][y] != '#') {
            if (vis.contains(x + 1 + "," + y)) {
                ans.add(new int[]{x - 1, y, x, y});
            }
            if (vis.contains(x - 1 + "," + y)) {
                ans.add(new int[]{x + 1, y, x, y});
            }
        }
        if (y + 1 < n && y - 1 >= 0 && grid[x][y + 1] != '#' && grid[x][y - 1] != '#') {
            if (vis.contains(x + "," + (y + 1))) {
                ans.add(new int[]{x, y - 1, x, y});
            }
            if (vis.contains(x + "," + (y - 1))) {
                ans.add(new int[]{x, y + 1, x, y});
            }
        }
        return ans;
    }
}