class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        List<int[]> temp = new ArrayList<>();
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.addLast(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty() || !temp.isEmpty()) {
            if (q.isEmpty()) {
                q.addAll(temp);
                temp.clear();
                ans++;
            }
            int[] cur = q.pollFirst();
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    temp.add(new int[]{nx, ny});
                    count--;
                }
            }
        }
        return count == 0 ? ans : -1;
    }
}