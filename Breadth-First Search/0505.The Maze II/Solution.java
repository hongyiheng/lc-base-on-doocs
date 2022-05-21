class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dis = new int[m][n];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(start);
        dis[start[0]][start[1]] = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                int step = 0;
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += d[0];
                    ny += d[1];
                    step++;
                }
                nx -= d[0];
                ny -= d[1];
                if (dis[nx][ny] > dis[x][y] + step) {
                    dis[nx][ny] = dis[x][y] + step;
                    q.offerLast(new int[]{nx, ny});
                }
            }
        }
        return dis[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dis[destination[0]][destination[1]];
    }
}