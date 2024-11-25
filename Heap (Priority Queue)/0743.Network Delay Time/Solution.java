class Solution {

    final int inf = 0x3f3f3f3f;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n + 1][n + 1];
        for (int[] f : g) {
            Arrays.fill(f, inf);
        }
        for (int[] t : times) {
            int u = t[0], v = t[1], w = t[2];
            g[u][v] = w;
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, inf);
        dist[k] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{k, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0], w = cur[1];
            for (int v = 1; v < n + 1; v++) {
                if (g[u][v] >= inf) {
                    continue;
                }
                if (g[u][v] + w >= dist[v]) {
                    continue;
                }
                dist[v] = g[u][v] + w;
                q.add(new int[]{v, dist[v]});
            }
        }
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans >= inf ? -1 : ans;
    }
}