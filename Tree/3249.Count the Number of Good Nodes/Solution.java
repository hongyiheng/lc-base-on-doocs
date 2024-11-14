class Solution {

    Map<Integer, List<Integer>> g;
    int ans;

    public int dfs(int u, int p) {
        int cnt = 1, t = 0;
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            int nv = dfs(v, u);
            if (t == 0 || t == nv) {
                t = nv;
            } else {
                t = -1;
            }
            cnt += nv;
        }
        if (t != -1) {
            ans++;
        }
        return cnt;
    }

    public int countGoodNodes(int[][] edges) {
        g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        dfs(0, -1);
        return ans;
    }
}