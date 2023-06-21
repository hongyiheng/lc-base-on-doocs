class Solution {

    int m, n;
    int[] rmi;
    int[][] f;

    public int dfs(int j, int mask, List<List<Integer>> cost) {
        if (f[j][mask] != -1) {
            return f[j][mask];
        }
        if (j == n) {
            int res = 0;
            for (int i = 0; i < m; i++) {
                if ((mask >> i & 1) == 0) {
                    res += rmi[i];
                }
            }
            return res;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.min(res, dfs(j + 1, mask | (1 << i), cost) + cost.get(i).get(j));
        }
        f[j][mask] = res;
        return res;
    }

    public int connectTwoGroups(List<List<Integer>> cost) {
        m = cost.size();
        n = cost.get(0).size();
        rmi = new int[m];
        f = new int[n + 1][1 << m];
        for (int[] r : f) {
            Arrays.fill(r, -1);
        }
        for (int i = 0; i < m; i++) {
            int mi = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                mi = Math.min(mi, cost.get(i).get(j));
            }
            rmi[i] = mi;
        }
        return dfs(0, 0, cost);
    }
}
