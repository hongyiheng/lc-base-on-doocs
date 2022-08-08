class Solution {
    int m;
    int[] nums;

    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        this.m = m;
        long left = 0, right = 0;
        for (int v : nums) {
            right = right + v;
        }
        while (left < right) {
            long mid = (left + right) >>> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int)left;
    }

    public boolean check(long x) {
        long cnt = 0, cur = 0;
        for (int v : nums) {
            if (v > x) {
                return false;
            }
            cur = cur + v;
            if (cur > x) {
                cur = v;
                cnt++;
            }
        }
        return cnt + 1 <= m;
    }
}