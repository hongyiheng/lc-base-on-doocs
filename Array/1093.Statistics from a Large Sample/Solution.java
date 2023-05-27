class Solution {
    public double[] sampleStats(int[] count) {
        double mi = 255, mx = 0, mean = 0, median = 0, mod = 0;
        long cnt = 0, val = 0, modMx = 0, n = count.length;
        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                cnt += count[i];
                val += 1L * count[i] * i;
                if (count[i] > modMx) {
                    modMx = count[i];
                    mod = i;
                }
                mi = Math.min(mi, i);
                mx = Math.max(mx, i);
            }
        }
        mean = (double) val / cnt;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += count[i];
            if (cnt % 2 == 0) {
                if (median == 0 && cur >= cnt / 2) {
                    median = i;
                }
                if (cur >= cnt / 2 + 1) {
                    median += i;
                    median /= 2;
                    break;
                }
            } else {
                if (cur > cnt / 2) {
                    median = i;
                    break;
                }
            }
        }
        return new double[]{mi, mx, mean, median, mod};
    }
}
