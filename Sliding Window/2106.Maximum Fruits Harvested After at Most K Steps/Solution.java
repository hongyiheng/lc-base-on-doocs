class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int m = fruits.length, n = 0;
        for (int i = 0; i < m; i++) {
            n = Math.max(n, fruits[i][0]);
        }
        int[] pre = new int[n + 2];
        int j = 0;
        for (int i = 0; i <= n; i++) {
            pre[i + 1] = pre[i];
            if (fruits[j][0] == i) {
                pre[i + 1] += fruits[j][1];
                j++;
            }
        }
        if (k == 0) {
            return startPos > n ? 0 : pre[startPos + 1] - pre[startPos];
        }
        int ans = 0;
        for (int l = startPos - k; l <= startPos; l++) {
            if (l > n) {
                break;
            }
            int r = Math.max(startPos, startPos + k - (startPos - l) * 2);
            ans = Math.max(ans, pre[Math.min(r, n) + 1] - pre[Math.max(0, l)]);
        }
        for (int r = startPos + k; r >= startPos; r--) {
            int l = Math.min(startPos, startPos - k + (r - startPos) * 2);
            if (l > n) {
                break;
            }
            ans = Math.max(ans, pre[Math.min(r, n) + 1] - pre[Math.max(0, l)]);
        }
        return ans;
    }
}
