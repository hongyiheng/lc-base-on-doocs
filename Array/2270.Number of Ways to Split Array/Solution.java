class Solution {
    public int waysToSplitArray(int[] nums) {
        long s = 0, cur = 0;
        for (int v : nums) {
            s += v;
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            cur += nums[i];
            s -= nums[i];
            if (cur >= s) {
                ans++;
            }
        }
        return ans;
    }
}