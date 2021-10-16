class Solution {
    int[] p;
    int[] area;

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        area = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            area[i] = 1;
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int index = i * n + j;
                int row = i;
                while (++row < m) {
                    if (grid[row][j] == 1) {
                        union(index, row * n + j);
                    }
                }
                int col = j;
                while (++col < n) {
                    if (grid[i][col] == 1) {
                        union(index, i * n + col);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (grid[i][j] == 1 && p[index] == index && area[index] > 1) {
                    ans += area[index];
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