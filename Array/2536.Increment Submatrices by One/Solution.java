class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];
        for (int[] q : queries) {
            int i1 = q[0], j1 = q[1], i2 = q[2], j2= q[3];
            for (int i = i1; i < i2 + 1; i++) {
                ans[i][j1]++;
                if (j2 + 1 < n) {
                    ans[i][j2 + 1]--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int v = 0;
            for (int j = 0; j < n; j++) {
                v += ans[i][j];
                ans[i][j] = v;
            }
        }
        return ans;
    }
}
