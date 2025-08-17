class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || k + maxPts <= n) {
            return 1.0;
        }
        double[] f = new double[n + 1];
        f[0] = 1.0;
        double cur = 0.0;
        for (int i = 1; i <= n; i++) {
            if (i <= k) {
                cur += f[i - 1];
            }
            if (i > maxPts) {
                cur -= f[i - 1 - maxPts];
            }
            f[i] = cur / maxPts;
        }

        double ans = 0.0;
        for (int i = k; i <= n; i++) {
            ans += f[i];
        }
        return ans;
    }
}
