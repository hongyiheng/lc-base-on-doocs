class Solution {
    int[] p;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int m = queries.length;
        int[][] qs = new int[m][4];
        for (int i = 0; i < m; i++) {
            qs[i][0] = i;
            qs[i][1] = queries[i][0];
            qs[i][2] = queries[i][1];
            qs[i][3] = queries[i][2];
        }
        Arrays.sort(qs, (a, b) -> a[3] - b[3]);
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        boolean[] ans = new boolean[m];
        int i = 0;
        for (int[] q : qs) {
            int j = q[0], u = q[1], v = q[2], limit = q[3];
            while (i < edgeList.length && edgeList[i][2] < limit) {
                p[find(edgeList[i][0])] = find(edgeList[i][1]);
                i++;
            }
            ans[j] = find(u) == find(v);
        }
        return ans;
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
