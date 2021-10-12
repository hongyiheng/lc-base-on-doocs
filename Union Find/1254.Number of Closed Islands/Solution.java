class Solution {
    int[] p;
    boolean[] border;
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        border = new boolean[m * n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                int index = i * n + j;
                if (i > 0 && grid[i - 1][j] == 0) {
                    p[find(index)] = find(index - n);
                }
                if (j > 0 && grid[i][j - 1] == 0) {
                    p[find(index)] = find(index - 1);
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
                if (grid[i][j] == 0 && p[i * n + j] == i * n + j && !border[i * n + j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}