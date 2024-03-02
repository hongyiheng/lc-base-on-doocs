class Solution {

    Set<Integer> s = new HashSet<>();
    Map<Integer, List<Integer>> g = new HashMap<>();

    public int dfs(int u, int p) {
        int ans = 0;
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p || s.contains(v)) {
                continue;
            }
            ans += dfs(v, u);
        }
        return ans + 1;
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        for (int v : restricted) {
            s.add(v);
        }
        if (s.contains(0)) {
            return 0;
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        return dfs(0, -1);
    }
}