class Solution {
    public int countHillValley(int[] nums) {
        int last = nums[0];
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if ((last < nums[i] && nums[i] > nums[i + 1]) || (last > nums[i] && nums[i] < nums[i + 1])) {
                ans++;
            }
            last = nums[i];
        }
        return ans;
    }
}