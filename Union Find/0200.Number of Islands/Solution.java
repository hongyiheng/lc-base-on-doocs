class Solution {
    int[] p;
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        p = new int[m * n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                       p[find(i * n + j)] = find((i + 1) * n + j);
                    }
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        p[find(i * n + j)] = find(i * n + (j + 1));
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && p[i * n + j] == i * n + j) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}