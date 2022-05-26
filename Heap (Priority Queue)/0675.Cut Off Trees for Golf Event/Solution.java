class Solution {
    int[][] grid;
    int m, n;

    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        m = forest.size();
        n = forest.get(0).size();
        grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = forest.get(i).get(j);
                if (forest.get(i).get(j) > 1) {
                    q.offer(new int[]{grid[i][j], i, j});
                }
            }
        }
        int x = 0, y = 0, ans = 0;
        while (!q.isEmpty()) {
            int[] ne = q.poll();
            int dis = astarSearch(x, y, ne[1], ne[2]);
            if (dis == -1) {
                return -1;
            }
            x = ne[1];
            y = ne[2];
            ans += dis;
        }
        return ans;
    }

    public int astarSearch(int a, int b, int c, int d) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> o1[0] - o2[0]);
        int[][] dis = new int[m][n];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        q.offer(new int[]{getF(a, b, c, d, 0), a, b});
        dis[a][b] = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[1], y = cur[2];
            int g = dis[x][y];
            if (x == c && y == d) {
                return g;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) {
                    continue;
                }
                if (dis[nx][ny] <= g + 1) {
                    continue;
                }
                dis[nx][ny] = g + 1;
                q.offer(new int[]{getF(nx, ny, c, d, dis[nx][ny]), nx, ny});
            }
        }
        return -1;
    }

    public int getF(int a, int b, int c, int d, int dis) {
        return Math.abs(a - c) + Math.abs(b - d) + dis;
    }
}