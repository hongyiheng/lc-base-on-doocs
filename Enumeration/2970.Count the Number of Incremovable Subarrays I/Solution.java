class Solution {
    public boolean check(int i, int j, int[] nums) {
        int last = 0;
        for (int k = 0; k < nums.length; k++) {
            if (i <= k && k <= j) {
                continue;
            }
            if (nums[k] <= last) {
                return false;
            }
            last = nums[k];
        }
        return true;
    }

    public int incremovableSubarrayCount(int[] nums) {
        int ans = 1, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j - i + 1 == n) {
                    continue;
                }
                if (check(i, j, nums)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}