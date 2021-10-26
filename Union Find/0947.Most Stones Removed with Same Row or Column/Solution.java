class Solution {
    int[] p;
    int count;
    public int removeStones(int[][] stones) {
        int m = stones.length;
        p = new int[m];
        count = m;
        for (int i = 0; i <m; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }
        return m - count;
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int i1, int i2) {
        int r1 = find(i1);
        int r2 = find(i2);
        if (r1 != r2) {
            p[r1] = r2;
            count--;
        }
    }
}