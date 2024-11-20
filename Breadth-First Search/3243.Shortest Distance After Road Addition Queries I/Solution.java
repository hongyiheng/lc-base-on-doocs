class Solution {

    public int bfs(Map<Integer, List<Integer>> g, int n) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        int d = 0;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                int u = q.pollFirst();
                if (u == n - 1) {
                    return d;
                }
                for (int v : g.get(u)) {
                    if (vis[v]) {
                        continue;
                    }
                    vis[v] = true;
                    q.add(v);
                }
            }
            d++;
        }
        return -1;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> vs = new ArrayList<>();
            vs.add(i + 1);
            g.put(i, vs);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            g.get(u).add(v);
            ans[i] = bfs(g, n);
        }
        return ans;
    }
}