class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;
        int[][] dis = new int[mask][n];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dis[1 << i][i] = 0;
            q.offer(new int[]{1 << i, i});
        }
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int state = cur[0], idx = cur[1];
            int step = dis[state][idx];
            for (int i : graph[idx]) {
                int nextState = state | (1 << i);
                if (dis[nextState][i] > step + 1) {
                    dis[nextState][i] = step + 1;
                    q.offer(new int[]{nextState, i});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dis[mask - 1][i]);
        }
        return ans;
    }
}