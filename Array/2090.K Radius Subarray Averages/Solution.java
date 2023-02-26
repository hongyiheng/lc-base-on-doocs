class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += nums[i];
            if (i >= 2 * k) {
                ans[i - k] = (int)(s / (2 * k + 1));
                s -= nums[i - 2 * k];
            }
        }
        return ans;
    }
}