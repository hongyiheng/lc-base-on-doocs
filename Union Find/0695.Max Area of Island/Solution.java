class Solution {
    int[] p;
    int[] area;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        area = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            p[i] = i;
            area[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        union(index, index - n);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        union(index, index - 1);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && p[i * n + j] == i * n + j) {
                    ans = Math.max(ans, area[i * n + j]);
                }
            }
        }
        return ans;
    }

    private void union(int index1, int index2) {
        int r1 = find(index1);
        int r2 = find(index2);
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