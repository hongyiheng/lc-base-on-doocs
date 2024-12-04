class Solution {

    boolean check(long x, int mountainHeight, int[] workerTimes) {
        long h = 0;
        for (int t : workerTimes) {
            int l = 0, r = mountainHeight;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if ((long) t * mid * (mid + 1) / 2 <= x) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            h += r;
        }
        return h >= mountainHeight;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 0, r = (1L + mountainHeight) * mountainHeight / 2 * workerTimes[0];
        while (l < r) {
            long mid = (l + r) >> 1;
            if (check(mid, mountainHeight, workerTimes)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}