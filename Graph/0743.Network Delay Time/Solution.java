class Solution {
    int N, T;
    int[] dist;
    int[][] edge;
    public int networkDelayTime(int[][] times, int n, int k) {
        N = n + 1;
        T = k;
        edge = new int[N][N];
        dist = new int[N];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                edge[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        for (int[] t : times) {
            edge[t[0]][t[1]] = t[2];
        }
        dijkstra();
        int ans = 0;
        for (int i = 1; i < N; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void dijkstra() {
        boolean[] vis = new boolean[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[T] = 0;
        for (int k = 1; k < N; k++) {
            int index = -1;
            for (int i = 1; i < N; i++) {
                if (vis[i]) {
                    continue;
                }
                if (index == - 1 || dist[index] > dist[i]) {
                    index = i;
                }
            }
            vis[index] = true;
            for (int j = 1; j < N; j++) {
                if (dist[index] == Integer.MAX_VALUE || edge[index][j] == Integer.MAX_VALUE) {
                    continue;
                }
                dist[j] = Math.min(dist[j], dist[index] + edge[index][j]);
            }
        }
    }
}