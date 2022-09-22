class Solution {
    int[][] g;
    int m, n;
    int[] rows;

    public int maximumRows(int[][] matrix, int numSelect) {
        this.g = matrix;
        m = matrix.length;
        n = matrix[0].length;
        rows = new int[m];
        for (int i = 0; i < m; i++) {
            int s = 0;
            for (int j = 0; j < n; j++) {
                if (g[i][j] != 0) {
                    s |= (1 << j);
                }
            }
            rows[i] = s;
        }
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (cnt(i) != numSelect) {
                continue;
            }
            ans = Math.max(cover(i), ans);
        }
        return ans;
    }

    public int cover(int mask) {
        int ans = 0;
        for (int s : rows) {
            if (mask == (1 << n) - 1 || (mask | s) == mask) {
                ans++;
            }
        }
        return ans;
    }

    public int cnt(int x) {
        int ans = 0;
        while (x > 0) {
            x &= x - 1;
            ans++;
        }
        return ans;
    }
}
