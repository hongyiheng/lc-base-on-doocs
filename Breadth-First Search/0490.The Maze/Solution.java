class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(start);
        vis[start[0]][start[1]] = true;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            for (int[] d : dirs) {
                int nx = cur[0] + d[0], ny = cur[1] + d[1];
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += d[0];
                    ny += d[1];
                }
                nx -= d[0];
                ny -= d[1];
                if (vis[nx][ny]) {
                    continue;
                }
                vis[nx][ny] = true;
                q.addLast(new int[]{nx, ny});
            }
        }
        return vis[destination[0]][destination[1]];
    }
}