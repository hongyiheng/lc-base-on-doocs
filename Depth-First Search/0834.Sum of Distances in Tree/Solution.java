class Solution {

    Map<Integer, List<Integer>> g = new HashMap<>();
    int[] depth, cnt, ans;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        depth = new int[n];
        cnt = new int[n];
        ans = new int[n];
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], x -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], x -> new ArrayList<>()).add(e[0]);
        }
        dfs(0, -1);
        for (int v : depth) {
            ans[0] += v;
        }
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int u, int p) {
        cnt[u] = 1;
        if (!g.containsKey(u)) {
            return;
        }
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            depth[v] = depth[u] + 1;
            dfs(v, u);
            cnt[u] += cnt[v];
        }
    }

    public void dfs2(int u, int p) {
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            ans[v] = ans[u] + (n - cnt[v]) - cnt[v];
            dfs2(v, u);
        }
    }
}
