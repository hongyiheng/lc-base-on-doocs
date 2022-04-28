class Solution {
    int[][] pre;
    int m, n;
    int threshold;
    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;
        pre = new int[m + 1][n + 1];
        this.threshold = threshold;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] + mat[i - 1][j - 1] - pre[i - 1][j - 1];
            }
        }
        int left = 0, right = Math.min(m, n);
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int mid) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < mid || j < mid) {
                    continue;
                }
                int s = pre[i][j] - pre[i][j - mid] - pre[i - mid][j] + pre[i - mid][j - mid];
                if (s <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}