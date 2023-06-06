class Solution {
    int a = 1, b = 2, n;
    Map<Integer, List<Integer>> g = new HashMap<>();
    int[] p;
    boolean[] vis;

    public boolean dfs(int u) {
        if (vis[u]) {
            return true;
        }
        vis[u] = true;
        p[u] = p[u] == 0 ? a : p[u];
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            p[v] = p[v] == 0 ? a + b - p[u] : p[v];
            if (p[u] == p[v] || !dfs(v)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        p = new int[n];
        vis = new boolean[n];
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }
}
