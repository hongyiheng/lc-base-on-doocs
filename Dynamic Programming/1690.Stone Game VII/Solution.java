class Solution {

    int[] pre;
    int[][] f;

    public int dfs(int l, int r) {
        if (l == r) {
            return 0;
        }
        if (f[l][r] != 0) {
            return f[l][r];
        }
        int a = pre[r + 1] - pre[l + 1] - dfs(l + 1, r);
        int b = pre[r] - pre[l] - dfs(l, r - 1);
        f[l][r] = Math.max(a, b);
        return Math.max(a, b);
    }

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        f = new int[n][n];
        pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stones[i];
        }
        return dfs(0, n - 1);
    }
}