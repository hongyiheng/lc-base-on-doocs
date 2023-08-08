class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int pos = 0, neg = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            pos = Math.max(pos + nums[i], 0);
            neg = Math.min(neg + nums[i], 0);
            ans = Math.max(ans, Math.max(pos, - neg));
        }
        return ans;
    }
}