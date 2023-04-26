class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie + 1;
        int left = 0, right = 1000;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (Math.pow(times, mid) < buckets) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}