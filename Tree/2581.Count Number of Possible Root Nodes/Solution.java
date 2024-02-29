class Solution {

    Map<Integer, List<Integer>> g = new HashMap<>();
    Set<Long> s = new HashSet<>();
    int cnt = 0, ans = 0;

    public void dfs(int u, int p) {
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v != p) {
                cnt += s.contains((long)u * 100000 + v) ? 1 : 0;
                dfs(v, u);
            }
        }
    }

    public void reroot(int u, int p, int cnt, int k) {
        ans += cnt >= k ? 1 : 0;
        for (int v : g.getOrDefault(u, new ArrayList<>())) {
            if (v != p) {
                reroot(v, u, cnt - (s.contains(u * 100000L + v) ? 1 : 0) + (s.contains(v * 100000L + u) ? 1 : 0), k);
            }
        }
    }

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], w -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], w -> new ArrayList<>()).add(e[0]);
        }
        for (int[] e : guesses) {
            s.add(e[0] * 100000L + e[1]);
        }
        dfs(0, -1);
        reroot(0, -1, cnt, k);
        return ans;
    }
}