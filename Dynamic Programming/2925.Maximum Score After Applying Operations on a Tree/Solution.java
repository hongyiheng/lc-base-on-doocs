class Solution {

    Map<Integer, List<Integer>> g;
    int[] values;

    public long dfs(int u, int p) {
        if (g.get(u).size() == 1 && u != 0) {
            return values[u];
        }
        long s = 0;
        for (int v : g.get(u)) {
            if (v == p) {
                continue;
            }
            s += dfs(v, u);
        }
        return Math.min(s, values[u]);
    }

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        g = new HashMap<>();
        this.values = values;
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        return Arrays.stream(values).mapToLong(e -> (long) e).sum() - dfs(0, -1);
    }
}