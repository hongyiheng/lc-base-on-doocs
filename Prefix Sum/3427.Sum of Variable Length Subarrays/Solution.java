class Solution {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += pre[i + 1] - pre[Math.max(0, i - nums[i])];
        }
        return ans;
    }
}