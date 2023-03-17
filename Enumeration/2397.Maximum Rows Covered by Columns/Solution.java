class Solution {
    public int bitCnt(int x) {
        int ans = 0;
        while (x > 0) {
            x -= x & -x;
            ans += 1;
        }
        return ans;
    }

    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int[] row = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    row[i] |= (1 << j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < (1 << n) + 1; i++) {
            if (bitCnt(i) != numSelect) {
                continue;
            }
            int cnt = 0;
            for (int r : row) {
                if ((r | i) == i) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
