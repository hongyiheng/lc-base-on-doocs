class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long left = 0, right = 0x3f3f3f3f3fL;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            if (check(stations.clone(), r, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int r, int k, long t) {
        int n = nums.length;
        long cur = 0;
        for (int i = 0; i <= r; i++) {
            cur += nums[i];
        }
        int left = 0, right = r;
        for (int i = 0; i < n; i++) {
            if (cur < t) {
                long diff = t - cur;
                if (diff > k) {
                    return false;
                }
                nums[Math.min(right, n - 1)] += diff;
                k -= diff;
                cur = t;
            }
            if (++right < n) {
                cur += nums[right];
            }
            if (right - left + 1 > 2 * r + 1) {
                cur -= nums[left++];
            }
        }
        return true;
    }
}