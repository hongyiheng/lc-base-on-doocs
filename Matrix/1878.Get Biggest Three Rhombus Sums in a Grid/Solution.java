class Solution {

    public int getS(int i, int j, int d, int[][] grid) {
        if (d == 0) {
            return grid[i][j];
        }
        int s = grid[i - d][j] + grid[i + d][j] + grid[i][j - d] + grid[i][j + d];
        for (int k = 1; k < d; k++) {
            int l = j - d + k, r = j + d - k;
            s += grid[i - k][l] + grid[i - k][r] + grid[i + k][l] + grid[i + k][r];
        }
        return s;
    }

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Set<Integer> vis = new HashSet<>();
        for (int d = 0; d < Math.min(m, n); d++) {
            for (int i = d; i < m - d; i++) {
                for (int j = d; j < n - d; j++) {
                    int s = getS(i, j, d, grid);
                    if (vis.contains(s)) {
                        continue;
                    }
                    vis.add(s);
                    q.add(s);
                    if (q.size() > 3) {
                        q.poll();
                    }
                }
            }
        }
        return q.stream().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();
    }
}