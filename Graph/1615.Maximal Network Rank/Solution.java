class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set[] g = new Set[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }
        for (int[] e : roads) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int v = g[i].size() + g[j].size();
                if (g[i].contains(j)) {
                    v--;
                }
                ans = Math.max(ans, v);
            }
        }
        return ans;
    }
}