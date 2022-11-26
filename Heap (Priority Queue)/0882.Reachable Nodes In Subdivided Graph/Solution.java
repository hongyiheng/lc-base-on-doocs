
class Solution {
    Map<Integer, List<int[]>> mp;

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        mp = new HashMap<>();
        for (int[] e : edges) {
            mp.computeIfAbsent(e[0], k -> new ArrayList<>()).add(new int[]{e[1], e[2] + 1});
            mp.computeIfAbsent(e[1], k -> new ArrayList<>()).add(new int[]{e[0], e[2] + 1});
        }
        int[] dist = dijkstra(n);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves) {
                ans++;
            }
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            int l = Math.max(maxMoves - dist[u], 0), r = Math.max(maxMoves - dist[v], 0);
            ans += Math.min(w, l + r);
        }
        return ans;
    }

    public int[] dijkstra(int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int u = q.poll()[1];
            for (int[] e : mp.getOrDefault(u, new ArrayList<>())) {
                int v = e[0], w = e[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    q.offer(new int[]{dist[v], v});
                }
            }
        }
        return dist;
    }
}
