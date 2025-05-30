class Solution {

    final int inf = 0x3f3f3f3f;

    public int[] bfs(int[] edges, int u) {
        int n = edges.length;
        int[] dis = new int[n];
        Arrays.fill(dis, inf);
        int d = 0;
        while (u != -1 && dis[u] > d) {
            dis[u] = d++;
            u = edges[u];
        }
        return dis;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1 = bfs(edges, node1), dis2 = bfs(edges, node2);
        int mi = inf, ans = -1;
        for (int i = 0; i < dis1.length; i++) {
            int d = Math.max(dis1[i], dis2[i]);
            if (mi > d) {
                mi = d;
                ans = i;
            }
        }
        return ans;
    }
}