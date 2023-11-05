class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int ans = vals[0];
        for (int v : vals) {
            ans = Math.max(ans, v);
        }
        if (k == 0) {
            return ans;
        }
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, o -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, o -> new ArrayList<>()).add(u);
        }
        int n = vals.length;
        for (int u = 0; u < n; u++) {
            List<Integer> vs = new ArrayList<>();
            for (int v : g.getOrDefault(u, new ArrayList<>())) {
                if (vals[v] <= 0) {
                    continue;
                }
                vs.add(vals[v]);
            }
            Collections.sort(vs, (a, b) -> b - a);
            int s = vals[u];
            for (int i = 0; i < Math.min(k, vs.size()); i++) {
                s += vs.get(i);
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }
}