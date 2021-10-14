class Solution {
    int[] p;
    int[] area;
    boolean[] border;

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        area = new int[m * n];
        border = new boolean[m * n];
        for (int i = 0; i < p.length; i++) {
            area[i] = 1;
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int index = i * n + j;
                if (i > 0 && grid[i - 1][j] == 1) {
                    union(index, index - n);
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    union(index, index - 1);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    border[find(i * n + j)] = true;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && p[i * n + j] == i * n + j && !border[i * n + j]) {
                    ans += area[i * n + j];
                }
            }
        }
        return ans;
    }

    private void union(int i1, int i2) {
        int r1 = find(i1);
        int r2 = find(i2);
        if (r1 != r2) {
            area[r2] += area[r1];
            p[r1] = r2;
        }
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}