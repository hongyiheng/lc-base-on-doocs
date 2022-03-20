class Solution {
    int N = 100010, M = N * 2;
    int[] edge = new int[M], head = new int[N], next = new int[M];
    int[] dist = new int[N];
    int idx = 0;

    void add(int a, int b) {
        edge[idx] = b;
        next[idx] = head[a];
        head[a] = idx++;
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        Arrays.fill(head, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        int n = patience.length;
        for (int[] e : edges) {
            add(e[0], e[1]);
            add(e[1], e[0]);
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        dist[0] = 0;
        while (!q.isEmpty()) {
            int t = q.pollFirst();
            for (int i = head[t]; i != -1; i = next[i]) {
                int j = edge[i];
                if (dist[j] != Integer.MAX_VALUE) {
                    continue;
                }
                dist[j] = dist[t] + 1;
                q.addLast(j);
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int di = dist[i] * 2, t = patience[i];
            int cur = di <= t ? di : (di - 1) / t * t + di;
            ans = Math.max(ans, cur);
        }
        return ans + 1;
    }
}