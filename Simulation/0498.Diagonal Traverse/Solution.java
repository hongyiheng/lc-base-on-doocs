class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int x = 0, y = 0, idx = 0;
        boolean up = true;
        for (int i = 0; i < m * n; i++) {
            ans[idx++] = mat[x][y];
            int nx = x, ny = y;
            nx += up? -1 : 1;
            ny += up? 1 : -1;
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                nx = x;
                ny = y;
                if (up) {
                    if (ny == n - 1) {
                        nx += 1;
                    } else {
                        ny += 1;
                    }
                } else {
                    if (nx == m - 1) {
                        ny += 1;
                    } else {
                        nx += 1;
                    }
                }
                up = !up;
            }
            x = nx;
            y = ny;
        }
        return ans;
    }
}