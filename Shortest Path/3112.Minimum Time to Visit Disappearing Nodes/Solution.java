class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] us = q.poll();
            int t = us[0], u = us[1];
            if (t > ans[u]) {
                continue;
            }
            for (int[] vs : g.getOrDefault(u, new ArrayList<>())) {
                int v = vs[0], w = vs[1];
                if (t + w >= disappear[v]) {
                    continue;
                }
                if (ans[v] == -1 || ans[v] > t + w) {
                    ans[v] = t + w;
                    q.offer(new int[]{t + w, v});
                }
            }
        }
        return ans;
    }
}