class Solution {
    public long maxStrength(int[] nums) {
        long mx = nums[0], mi = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long tmp = mx;
            mx = Math.max(Math.max(mx, nums[i]), Math.max(mx * nums[i], mi * nums[i]));
            mi = Math.min(Math.min(mi, nums[i]), Math.min(tmp * nums[i], mi * nums[i]));
        }
        return Math.max(mx, mi);
    }
}