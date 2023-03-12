class Solution {

    int d, vis;
    List<Integer>[] g;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[0] - 1].add(e[1] - 1);
            g[e[1] - 1].add(e[0] - 1);
        }
        int[] ans = new int[n - 1];
        for (int mask = 1; mask < 1 << n; mask++) {
            if ((mask & (mask - 1)) == 0) {
                continue;
            }
            vis = 0;
            d = 0;
            dfs(Integer.numberOfTrailingZeros(mask), mask);
            if (vis == mask) {
                ans[d - 1]++;
            }
        }
        return ans;
    }

    public int dfs(int u, int mask) {
        vis |= 1 << u;
        int ans = 0;
        for (int v : g[u]) {
            if ((vis >> v & 1) == 0 && (mask >> v & 1) == 1) {
                int nx = dfs(v, mask) + 1;
                d = Math.max(d, ans + nx);
                ans = Math.max(ans, nx);
            }
        }
        return ans;
    }
}