class Solution {

    int inf = (int) 1e9 * 2;

    public long dijkstra(int n, int[][] edges, int source, int destination) {
        int[][] g = new int[n][n];
        for (int[] row : g) {
            Arrays.fill(row, inf);
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (w == -1) {
                continue;
            }
            g[u][v] = g[v][u] = Math.min(g[u][v], w);
        }
        long[] dist = new long[n];
        Arrays.fill(dist, inf);
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        q.add(new long[]{0, source});
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            long w = cur[0];
            int u = (int) cur[1];
            for (int v = 0; v < n; v++) {
                if (w + g[u][v] < dist[v]) {
                    dist[v] = w + g[u][v];
                    q.add(new long[]{dist[v], v});
                }
            }
        }
        return dist[destination];
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        long d = dijkstra(n, edges, source, destination);
        if (d < target) {
            return new int[0][];
        }
        boolean ok = d == target;
        for (int[] e : edges) {
            if (e[2] > 0) {
                continue;
            }
            if (ok) {
                e[2] = inf;
                continue;
            }
            e[2] = 1;
            d = dijkstra(n, edges, source, destination);
            if (d <= target) {
                ok = true;
                e[2] += target - d;
            }
        }
        return ok ? edges : new int[0][];
    }
}