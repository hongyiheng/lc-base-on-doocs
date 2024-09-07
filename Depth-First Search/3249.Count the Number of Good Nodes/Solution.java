class Solution {

    Map<Integer, List<Integer>> g;
    int ans;

    public int dfs(int u, int p) {
        List<Integer> child = g.getOrDefault(u, new ArrayList<>());
        int t = -1, s = 1, cnt = 0;
        for (int v : child) {
            if (v == p) {
                continue;
            }
            cnt++;
            int nv = dfs(v, u);
            if (t == -1) {
                t = nv;
            } else if (t != nv) {
                t = -2;
            }
            s += nv;
        }
        if (cnt == 0 || t != -2) {
            ans++;
        }
        return s;
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