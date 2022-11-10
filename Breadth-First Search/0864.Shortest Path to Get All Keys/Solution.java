class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length, m = grid[0].length();
        Deque<int[]> q = new ArrayDeque<>();
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '@') {
                    q.addLast(new int[]{i, j, 0});
                }
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'z') {
                    t |= (1 << (grid[i].charAt(j) - 'a'));
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Map<String, Boolean> vis = new HashMap<>();
        int w = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1], mask = cur[2];
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    char c = grid[nx].charAt(ny);
                    if (c == '#') {
                        continue;
                    }
                    if (vis.getOrDefault(nx + "," + ny + "," + mask, false)) {
                        continue;
                    }
                    vis.put(nx + "," + ny + "," + mask, true);
                    if (c >= 'A' && c <= 'Z' && ((1 << (c - 'A')) & mask) == 0) {
                        continue;
                    }
                    if (c >= 'a' && c <= 'z') {
                        int nextMask = (mask | (1 << (c - 'a')));
                        if (nextMask == t) {
                            return w + 1;
                        }
                        q.addLast(new int[]{nx, ny, nextMask});
                        continue;
                    }
                    q.addLast(new int[]{nx, ny, mask});
                }
            }
            w++;
        }
        return -1;
    }
}
