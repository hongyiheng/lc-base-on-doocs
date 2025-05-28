class Solution {

    public Map<Integer, List<Integer>> build(int[][] edge) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edge) {
            g.computeIfAbsent(e[0], x -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], x -> new ArrayList<>()).add(e[0]);
        }
        return g;
    }

    public int dfs(Map<Integer, List<Integer>> g, int u, int p, int d) {
        if (d < 0) {
            return 0;
        }
        int ans = 1;
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            ans += dfs(g, v, u, d - 1);
        }
        return ans;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length, m = edges2.length;
        Map<Integer, List<Integer>> g1 = build(edges1);
        Map<Integer, List<Integer>> g2 = build(edges2);
        int mx = 0;
        for (int i = 0; i <= m; i++) {
            mx = Math.max(mx, dfs(g2, i, -1, k - 1));
        }
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = dfs(g1, i, -1, k) + mx;
        }
        return ans;
    }

}