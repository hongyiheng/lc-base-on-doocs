class Solution {
    int m, n;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Deque<int[]> pacificQueue = new ArrayDeque<>();
        Deque<int[]> atlanticQueue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pacific[i][j] = true;
                    pacificQueue.offer(new int[]{i, j});
                }
                if (i == m - 1 || j == n - 1) {
                    atlantic[i][j] = true;
                    atlanticQueue.offer(new int[]{i, j});
                }
            }
        }
        bfs(pacific, pacificQueue);
        bfs(atlantic, atlanticQueue);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    ans.add(item);
                }
            }
        }
        return ans;
    }

    public void bfs(boolean[][] res, Deque<int[]> q) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (res[nx][ny] || heights[nx][ny] < heights[x][y]) {
                    continue;
                }
                res[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}