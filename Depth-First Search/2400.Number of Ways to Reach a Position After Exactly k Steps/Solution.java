class Solution {

    int mod = (int)1e9 + 7;
    int endPos;
    int[][] f;

    public int numberOfWays(int startPos, int endPos, int k) {
        this.endPos = endPos;
        f = new int[3010][1010];
        for (int[] r : f) {
            Arrays.fill(r, -1);
        }
        return dfs(startPos + 1000, k);
    }

    public int dfs(int cur, int left) {
        if (Math.abs(cur - endPos - 1000) > left) {
            return 0;
        }
        if (left == 0) {
            return 1;
        }
        if (f[cur][left] != -1) {
            return f[cur][left];
        }
        f[cur][left] = (dfs(cur - 1, left - 1) + dfs(cur + 1, left - 1)) % mod;
        return f[cur][left];
    }
}