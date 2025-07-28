class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[][] scope = new long[n][2];
        long s = 0;
        for (int i = 0; i < n; i++) {
            scope[i][0] = s + 1;
            s += candiesCount[i];
            scope[i][1] = s;
        }
        int m = queries.length;
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; i++) {
            int t = queries[i][0], d = queries[i][1], c = queries[i][2];
            long l = scope[t][0], r = scope[t][1];
            ans[i] = (long)(d + 1) * c >= l && d + 1 <= r;
        }
        return ans;
    }
}