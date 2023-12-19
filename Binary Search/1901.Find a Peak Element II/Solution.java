class Solution {
    public int getMaxCol(int[][] mat, int i) {
        int mx = 0, idx = 0;
        for (int j = 0; j < mat[i].length; j++) {
            if (mx < mat[i][j]) {
                mx = mat[i][j];
                idx = j;
            }
        }
        return idx;
    }

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int j = getMaxCol(mat, mid);
            if (mid < m - 1 && mat[mid][j] <= mat[mid + 1][j]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return new int[]{l, getMaxCol(mat, l)};
    }
}