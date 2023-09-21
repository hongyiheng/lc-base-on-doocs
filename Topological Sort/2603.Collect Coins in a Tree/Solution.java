class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        int[] to = new int[n];
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            to[u]++;
            to[v]++;
        }
        int cnt = edges.length;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (to[i] == 1 && coins[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer v = q.poll();
            cnt--;
            for (int u : g.getOrDefault(v, new ArrayList<>())) {
                if (--to[u] == 1 && coins[u] == 0) {
                    q.add(u);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (to[i] == 1 && coins[i] == 1) {
                q.add(i);
            }
        }
        for (int v : q) {
            cnt--;
            for (int u : g.getOrDefault(v, new ArrayList<>())) {
                if (--to[u] == 1) {
                    cnt--;
                }
            }
        }
        return Math.max(cnt * 2, 0);
    }
}