class Solution {
    int[] p;
    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        p = new int[m + 1];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            if (find(edges[i][0]) != find(edges[i][1])) {
                union(edges[i][0], edges[i][1]);
            } else {
                return edges[i];
            }
        }
        return edges[m - 1];
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int i1, int i2) {
        int r1 = find(i1);
        int r2 = find(i2);
        if (r1 != r2) {
            p[r1] = r2;
        }
    }
}