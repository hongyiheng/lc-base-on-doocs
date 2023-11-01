class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] ins = new int[n];
        for (int v : favorite) {
            ins[v]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (ins[i] == 0) {
                q.add(i);
            }
        }
        int[] dist = new int[n];
        while (!q.isEmpty()) {
            int u = q.poll();
            int v = favorite[u];
            dist[v] = Math.max(dist[v], dist[u] + 1);
            if (--ins[v] == 0) {
                q.add(v);
            }
        }
        Set<Integer> vis = new HashSet<>();
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < n; i++) {
            if (ins[i] == 0 || vis.contains(i)) {
                continue;
            }
            int j = favorite[i], d = 1;
            while (j != i) {
                vis.add(j);
                d++;
                j = favorite[j];
            }
            if (d == 2) {
                ans2 += d + dist[i] + dist[favorite[i]];
            } else {
                ans1 = Math.max(ans1, d);
            }
        }
        return Math.max(ans1, ans2);
    }
}