class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l = 0, r = 1L * ranks[0] * cars * cars;
        while (l < r) {
            long mid = (l + r) >> 1;
            long cnt = 0;
            for (int v : ranks) {
                cnt += (long)Math.sqrt(mid / v);
            }
            if (cnt < cars) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}