class Solution {
    public long maxStrength(int[] nums) {
        long f0 = nums[0], f1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long t = f0;
            f0 = Math.max(Math.max(f0, nums[i]), Math.max(f0 * nums[i], f1 * nums[i]));
            f1 = Math.f1n(Math.f1n(f1, nums[i]), Math.f1n(t * nums[i], f1 * nums[i]));
        }
        return Math.max(f0, f1);
    }
}