class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, t});
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, t});
        }
        int[] ts = new int[n];
        Arrays.fill(ts, Integer.MAX_VALUE);
        ts[0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{passingFees[0], 0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int d = cur[0], t = cur[1], u = cur[2];
            for (int[] nv : g.getOrDefault(u, new ArrayList<>())) {
                int v = nv[0], vt = nv[1];
                int nd = d + passingFees[v], nt = t + vt;
                if (nt > maxTime || nt >= ts[v]) {
                    continue;
                }
                if (v == n - 1) {
                    return nd;
                }
                ts[v] = nt;
                q.add(new int[]{nd, nt, v});
            }
        }
        return -1;
    }
}
