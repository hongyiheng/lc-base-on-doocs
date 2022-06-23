class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (grid[a[0]][a[1]] != grid[b[0]][b[1]]) {
                return grid[a[0]][a[1]] - grid[b[0]][b[1]];
            }
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        q.add(start);
        vis[start[0]][start[1]] = true;
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty() && ans.size() < k) {
            List<int[]> tmp = new ArrayList<>();
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                if (pricing[0] <= grid[x][y] && grid[x][y] <= pricing[1]) {
                    List<Integer> item = new ArrayList<>();
                    item.add(x);
                    item.add(y);
                    ans.add(item);
                    if (ans.size() == k) {
                        break;
                    }
                }
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] == 0 || vis[nx][ny]) {
                        continue;
                    }
                    tmp.add(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
            for (int[] ne : tmp) {
                q.add(ne);
            }
        }
        return ans;
    }
}