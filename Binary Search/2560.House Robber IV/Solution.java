class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 0, r = (int)1e9;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(nums, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public boolean check(int[] nums, int x, int k) {
        int f0 = 0, f1 = nums[0] <= x ? 1 : 0;
        for (int i = 2; i < nums.length + 1; i++) {
            int cur = f1;
            if (nums[i - 1] <= x) {
                cur = Math.max(cur, f0 + 1);
            }
            f0 = f1;
            f1 = cur;
        }
        return Math.max(f0, f1) >= k;
    }
}