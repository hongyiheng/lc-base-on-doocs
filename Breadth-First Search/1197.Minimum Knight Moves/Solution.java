class Solution {
    public int minKnightMoves(int i, int j) {
        int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        i = Math.abs(i);
        j = Math.abs(j);
        Set<String> vis = new HashSet<>();
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0});
        int ans = 0;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int k = 0; k < m; k++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1];
                if (x == i && y == j) {
                    return ans;
                }
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < -2 || nx > 300 || ny < -2 || ny > 300) {
                        continue;
                    }
                    if (!vis.contains(nx + "," + ny)) {
                        vis.add(nx + "," + ny);
                        q.addLast(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
