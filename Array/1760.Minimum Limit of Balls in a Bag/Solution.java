class Solution {

    public boolean check(int[] nums, int x, int maxOperations) {
        int ans = 0;
        for (int v : nums) {
            if (v > x) {
                ans += (v - 1) / x;
            }
            if (ans > maxOperations) {
                return false;
            }
        }
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = (int)1e9;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(nums, mid, maxOperations)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}