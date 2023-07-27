class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;
        int mx = grid[0][0] + 1, cnt = 0;
        List<int[]> arr = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int v = cur[0], x = cur[1], y = cur[2];
            if (v >= mx) {
                arr.add(new int[]{mx, cnt});
                mx = v + 1;
            }
            cnt++;
            for (int[] d : new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (vis[nx][ny]) {
                    continue;
                }
                vis[nx][ny] = true;
                q.add(new int[]{grid[nx][ny], nx, ny});
            }
        }
        arr.add(new int[]{mx, cnt});
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = 0, r = arr.size() - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (queries[i] < arr.get(mid)[0]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            if (queries[i] >= arr.get(r)[0]) {
                ans[i] = arr.get(r)[1];
            }
        }
        return ans;
    }
}