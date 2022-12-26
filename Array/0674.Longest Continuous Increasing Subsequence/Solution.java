class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1, cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur++;
            } else {
                cur = 1;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}