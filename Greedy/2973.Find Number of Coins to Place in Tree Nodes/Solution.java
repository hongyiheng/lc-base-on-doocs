class Solution {

    Map<Integer, List<Integer>> g;
    int[] cost;
    long[] ans;

    public List<List<Integer>> dfs(int u, int p) {
        List<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
        if (cost[u] >= 0) {
            pos.add(cost[u]);
        } else {
            neg.add(cost[u]);
        }
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            List<List<Integer>> res = dfs(v, u);
            pos.addAll(res.get(0));
            neg.addAll(res.get(1));
        }
        if (pos.size() + neg.size() >= 3) {
            pos.sort((a, b) -> b - a);
            neg.sort((a, b) -> a - b);
            if (pos.size() >= 3) {
                ans[u] = 1L * pos.get(0) * pos.get(1) * pos.get(2);
            }
            if (pos.size() >= 1 && neg.size() >= 2) {
                ans[u] = Math.max(ans[u], 1L * pos.get(0) * neg.get(0) * neg.get(1));
            }
            pos = pos.subList(0, Math.min(pos.size(), 3));
            neg = neg.subList(0, Math.min(neg.size(), 2));
        } else {
            ans[u] = 1;
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(pos);
        res.add(neg);
        return res;
    }

    public long[] placedCoins(int[][] edges, int[] cost) {
        g = new HashMap<>();
        this.cost = cost;
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        ans = new long[cost.length];
        dfs(0, -1);
        return ans;
    }
}