class Solution {
    public int search(int x, int v, int[] nums) {
        int l = 0, r = x;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] < v) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[r] < v ? r + 1 : 0;
    }

    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l + 1 < n && nums[l] < nums[l + 1]) {
            l++;
        }
        if (l == n - 1) {
            return 1L * (n + 1) * n / 2;
        }
        while (r - 1 >= 0 && nums[r - 1] < nums[r]) {
            r--;
        }
        long ans = l + 2;
        for (int i = r; i < n; i++) {
            ans += search(l, nums[i], nums) + 1;
        }
        return ans;
    }
}