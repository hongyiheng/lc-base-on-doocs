class Solution {
    int[] p;
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    p[find(i)] = find(j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (p[i] == i) {
                ans++;
            }
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}