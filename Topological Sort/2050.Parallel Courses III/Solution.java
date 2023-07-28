class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] ins = new int[n + 1];
        for (int[] relation : relations) {
            int u = relation[0], v = relation[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            ins[v]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (ins[i] == 0) {
                q.add(i);
                dist[i] = time[i - 1];
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.getOrDefault(u, new ArrayList<>())) {
                ins[v]--;
                dist[v] = Math.max(dist[v], dist[u] + time[v - 1]);
                if (ins[v] == 0) {
                    q.add(v);
                }
            }
        }
        int ans = 0;
        for (int v : dist) {
            ans = Math.max(ans, v);
        }
        return ans;
    }
}