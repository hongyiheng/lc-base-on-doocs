class Solution {

    int n, m, limit;
    int[] high;
    int[] low;
    String s;
    long[] f;

    public long dfs(int i, boolean limitLow, boolean limitHigh) {
        if (i == n) {
            return 1;
        }
        if (!limitLow && !limitHigh && f[i] != -1) {
            return f[i];
        }
        int lo = limitLow ? low[i] : 0;
        int hi = limitHigh ? high[i] : 9;
        long res = 0;
        if (i < m) {
            for (int d = lo; d < Math.min(hi, limit) + 1; d++) {
                res += dfs(i + 1, limitLow && d == lo, limitHigh && d == hi);
            }
        } else {
            int x = s.charAt(i - m) - '0';
            if (lo <= x && x <= hi) {
                res += dfs(i + 1, limitLow && x == lo, limitHigh && x == hi);
            }
        }
        if (!limitLow && !limitHigh) {
            f[i] = res;
        }
        return res;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.limit = limit;
        this.n = String.valueOf(finish).length();
        this.m = n - s.length();
        this.s = s;
        low = new int[n];
        high = new int[n];
        for (int i = n - 1; i > -1; i--) {
            if (start > 0) {
                low[i] = (int)(start % 10);
                start /= 10;
            }
            high[i] = (int)(finish % 10);
            finish /= 10;
        }
        f = new long[n];
        Arrays.fill(f, -1);
        return dfs(0, true, true);
    }
}


