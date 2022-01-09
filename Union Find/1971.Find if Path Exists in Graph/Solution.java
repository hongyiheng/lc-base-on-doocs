class Solution {
    int[] p;
    public boolean validPath(int n, int[][] edges, int start, int end) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return find(start) == find(end);
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