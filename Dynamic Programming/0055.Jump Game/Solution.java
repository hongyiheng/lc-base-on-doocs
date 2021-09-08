class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return true;
        }
        int max = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(i + nums[i], max);
            if (max >= len - 1) {
                return true;
            }
        }
        return false;
    }
}