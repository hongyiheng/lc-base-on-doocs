class Solution {
    int n;
    int[] edges;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        this.edges = edges;
        n = edges.length;
        int[] d1 = getDistance(node1);
        int[] d2 = getDistance(node2);
        int ans = -1, cur = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int d = Math.max(d1[i], d2[i]);
            if (cur > d) {
                cur = d;
                ans = i;
            }
        }
        return ans;
    }

    public int[] getDistance(int x) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int d = 0;
        while (x != -1 && dist[x] == Integer.MAX_VALUE) {
            dist[x] = d++;
            x = edges[x];
        }
        return dist;
    }
}