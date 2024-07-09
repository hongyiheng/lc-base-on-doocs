class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        double ans = nums[n - 1];
        int l = 0, r = n - 1;
        while (l < r) {
            ans = Math.min(ans, (1.0 * nums[l++] + nums[r--]) / 2);
        }
        return ans;
    }
}