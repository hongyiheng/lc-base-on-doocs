class Solution {
    public int alternatingSubarray(int[] nums) {
        int n = nums.length, ans = 0, cur = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] + 1 == nums[i] || nums[i - 1] - 1 == nums[i]) {
                if (cur != 0 && i >= 2 && nums[i - 2] == nums[i]) {
                    cur++;
                } else if (nums[i - 1] + 1 == nums[i]) {
                    cur = 2;
                } else {
                    cur = 0;
                }
            }
            ans = Math.max(ans, cur);
        }
        return ans == 0 ? -1 : ans;
    }
}