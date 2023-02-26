class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int mx = nums[0], mi = nums[0], mx_idx = 0, mi_idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > mx) {
                mx = nums[i];
                mx_idx = i;
            }
            if (nums[i] < mi) {
                mi = nums[i];
                mi_idx = i;
            }
        }
        int ans = Math.max(mi_idx, mx_idx) + 1;
        ans = Math.min(ans, Math.max(n - mi_idx, n - mx_idx));
        ans = Math.min(ans, Math.min(mi_idx, mx_idx) + 1 + n - Math.max(mi_idx, mx_idx));
        return ans;
    }
}