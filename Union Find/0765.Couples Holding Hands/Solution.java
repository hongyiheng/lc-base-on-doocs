class Solution {
    int[] p;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        int r1 = find(a), r2 = find(b);
        if (r1 != r2) {
            p[r1] = r2;
        }
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int m = n / 2;
        p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (p[i] == i) {
                cnt++;
            }
        }
        return m - cnt;
    }
}