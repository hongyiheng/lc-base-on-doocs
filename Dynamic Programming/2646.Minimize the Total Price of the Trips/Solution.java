class Solution {

    Map<Integer, List<Integer>> g;
    int[] cnt;
    int[] price;

    public boolean dfs(int u, int p, int t) {
        if (u == t) {
            cnt[u]++;
            return true;
        }
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            if (dfs(v, u, t)) {
                cnt[u]++;
                return true;
            }
        }
        return false;
    }

    public int[] f(int u, int p) {
        int c = price[u] * cnt[u];
        int hc = c / 2;
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            int[] ne = f(v, u);
            c += Math.min(ne[0], ne[1]);
            hc += ne[0];
        }
        return new int[]{c, hc};
    }

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        g = new HashMap<>();
        cnt = new int[n];
        this.price = price;

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        for (int[] e : trips) {
            int u = e[0], v = e[1];
            dfs(u, -1, v);
        }

        int[] ans = f(0, -1);
        return Math.min(ans[0], ans[1]);
    }
}