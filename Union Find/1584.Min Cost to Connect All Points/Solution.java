class Solution {
    int[] p;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        p[find(a)] = find(b);
    }

    public boolean check(int a, int b) {
        return find(a) != find(b);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                q.add(new int[]{dist, i, j});
            }
        }
        int ans = 0, cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int dist = cur[0], i = cur[1], j = cur[2];
            if (!check(i, j)) {
                continue;
            }
            ans += dist;
            union(i, j);
            if (cnt++ == n - 1) {
                break;
            }
        }
        return ans;
    }
}