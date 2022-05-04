class Solution {
    int[] weights;
    public int shipWithinDays(int[] weights, int days) {
        this.weights = weights;
        int left = 0, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (check(mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int k, int days) {
        int cur = 0, useDay = 1;
        for (int w : weights) {
            if (w > k) {
                return false;
            }
            cur += w;
            if (cur > k) {
                cur = w;
                useDay++;
            }
        }
        return useDay <= days;
    }
}