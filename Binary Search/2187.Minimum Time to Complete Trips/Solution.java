class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long minTime = Integer.MAX_VALUE;
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }
        long left = 0, right = minTime * totalTrips;
        while (left < right) {
            long mid = (left + right) >>> 1;
            if (check(time, mid, totalTrips)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] time, long mid, int totalTrips) {
        long cnt = 0;
        for (int t : time) {
            cnt += mid / t;
        }
        return cnt >= totalTrips;
    }
}