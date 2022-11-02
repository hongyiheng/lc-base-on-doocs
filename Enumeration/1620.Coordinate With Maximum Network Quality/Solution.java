class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int M = 55;
        int[][] g = new int[M][M];
        int[] ans = new int[]{0, 0};
        int cur = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                for (int[] t : towers) {
                    int x = t[0], y = t[1], w = t[2];
                    double d = Math.sqrt((x - i) * (x - i) + (y - j) * (y - j));
                    if (d <= radius) {
                        g[i][j] += w / (1 + d);
                    }
                }
                if (g[i][j] > cur) {
                    cur = g[i][j];
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
