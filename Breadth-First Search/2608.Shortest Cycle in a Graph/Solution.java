class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int ans = n + 1;
        for (int i = 0; i < n; i++) {
            int[] dis = new int[n];
            Arrays.fill(dis, -1);
            dis[i] = 0;
            Deque<int[]> q = new ArrayDeque<>();
            q.addLast(new int[]{i, -1});
            while (!q.isEmpty()) {
                int[] cur = q.pollFirst();
                int u = cur[0], p = cur[1];
                for (int v : g.getOrDefault(u, new ArrayList<>())) {
                    if (dis[v] < 0) {
                        dis[v] = dis[u] + 1;
                        q.addLast(new int[]{v, u});
                    } else if (v != p) {
                        ans = Math.min(ans, dis[u] + dis[v] + 1);
                    }
                }
            }
        }
        return ans > n ? -1 : ans;
    }
}