class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] g = new boolean[n][n];
        for (int[] d : dig) {
            g[d[0]][d[1]] = true;
        }
        int ans = 0;
        for (int[] a : artifacts) {
            boolean flag = true;
            for (int i = a[0]; i <= a[2] && flag; i++) {
                for (int j = a[1]; j <= a[3] && flag; j++) {
                    if (!g[i][j]) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}