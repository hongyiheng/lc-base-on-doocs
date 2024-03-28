class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int MOD = (int)1e9 + 7;
        long[] f = new long[n];
        for (int i = 1; i < n; i++) {
            f[i] = (f[i - 1] + 1 + f[i - 1] - f[nextVisit[i - 1]] + 1 + MOD) % MOD;
        }
        return (int)f[n - 1];
    }
}