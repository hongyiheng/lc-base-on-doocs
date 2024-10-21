class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int mi = nums[0], mx = nums[n - 1];
        int ans = mx - mi;
        for (int i = 0; i < n - 1; i++) {
            int a = nums[i], b = nums[i + 1];
            ans = Math.min(ans, Math.max(mx - k, a + k) - Math.min(mi + k, b - k));
        }
        return ans;
    }
}