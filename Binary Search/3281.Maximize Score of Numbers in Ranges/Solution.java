class Solution {

    int n;

    public boolean check(int[] start, int d, long x) {
        long last = start[0];
        for (int i = 1; i < n; i++) {
            if (last + x > start[i] + d) {
                return false;
            }
            last = Math.max(last + x, start[i]);
        }
        return true;
    }

    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        n = start.length;
        long l = 0, r = start[n - 1] - start[0] + 2L * d;
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (check(start, d, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int)r;
    }
}