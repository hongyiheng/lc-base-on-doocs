class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long f0 = nums[0], f1 = 0;
        for (int i = 1; i < n; i++) {
            long tmp = f0;
            f0 = Math.max(f0, f1 + nums[i]);
            f1 = Math.max(f1, tmp - nums[i]);
        }
        return Math.max(f0, f1);
    }
}