class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] f = new int[n][n], mxs = new int[n][n];
        for (int[] row : f) {
            Arrays.fill(row, 0x3f3f3f3f);
        }
        for (int r = 0; r < n; r++) {
            f[r][r] = 0;
            mxs[r][r] = arr[r];
            for (int l = r - 1; l > -1; l--) {
                mxs[l][r] = Math.max(arr[l], mxs[l + 1][r]);
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + mxs[l][k] * mxs[k + 1][r]);
                }
            }
        }
        return f[0][n - 1];
    }
}