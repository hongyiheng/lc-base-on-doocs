class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        long[] f = new long[n + 1];
        int j = 0;
        for (int i = 1; i < n + 1; i++) {
            f[i] = f[i - 1];
            while (j < rides.length && rides[j][1] == i) {
                int s = rides[j][0], e = rides[j][1], t = rides[j][2];
                f[i] = Math.max(f[i], f[s] + e - s + t);
                j++;
            }
        }
        return f[n];
    }
}