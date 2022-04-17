class Solution {
    int[] nums;
    int threshold;
    public int smallestDivisor(int[] nums, int threshold) {
        this.nums = nums;
        this.threshold = threshold;
        int left = 1, right = 1;
        for (int v : nums) {
            right = Math.max(right, v);
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int x) {
        int ans = 0;
        for (int v : nums) {
            ans += (v + x - 1) / x;
        }
        return ans <= threshold;
    }
}