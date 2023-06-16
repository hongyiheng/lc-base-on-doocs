class Solution {

    int[] g;
    int n, k;
    Map<Integer, Integer> f = new HashMap<>();

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        this.n = n;
        this.k = k;
        g = new int[n];
        for (int[] r : relations) {
            int u = r[0] - 1, v = r[1] - 1;
            g[v] |= (1 << u);
        }
        return dfs(0);
    }

    public int dfs(int x) {
        if (f.containsKey(x)) {
            return f.get(x);
        }
        if (x == (1 << n) - 1) {
            return 0;
        }
        int nx = 0;
        for (int i = 0; i < n; i++) {
            if ((x & g[i]) == g[i]) {
                nx |= (1 << i);
            }
        }
        nx ^= x;
        int res = n;
        if (Integer.bitCount(nx) <= k) {
            res = dfs(nx | x) + 1;
        } else {
            int msk = nx;
            while (msk > 0) {
                if (Integer.bitCount(msk) == k) {
                    res = Math.min(res, dfs(msk | x) + 1);
                }
                msk = (msk - 1) & nx;
            }
        }
        f.put(x, res);
        return res;
    }
}
