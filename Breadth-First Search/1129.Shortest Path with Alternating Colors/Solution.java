class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> r = new HashMap<>(), b = new HashMap<>();
        for (int[] e : redEdges) {
            r.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
        }
        for (int[] e : blueEdges) {
            b.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
        }
        int[][] dist = new int[n][2];
        for (int i = 1; i < n; i++) {
            dist[i][0] = dist[i][1] = -1;
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            if (dist[u][0] != -1) {
                for (int v : r.getOrDefault(u, Collections.emptyList())) {
                    if (dist[v][1] == -1 || dist[v][1] > dist[u][0] + 1) {
                        dist[v][1] = dist[u][0] + 1;
                        q.addLast(v);
                    }
                }
            }
            if (dist[u][1] != -1) {
                for (int v : b.getOrDefault(u, Collections.emptyList())) {
                    if (dist[v][0] == -1 || dist[v][0] > dist[u][1] + 1) {
                        dist[v][0] = dist[u][1] + 1;
                        q.addLast(v);
                    }
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i][0] == -1) {
                ans[i] = dist[i][1];
            } else if (dist[i][1] == -1) {
                ans[i] = dist[i][0];
            } else {
                ans[i] = Math.min(dist[i][0], dist[i][1]);
            }
        }
        return ans;
    }
}