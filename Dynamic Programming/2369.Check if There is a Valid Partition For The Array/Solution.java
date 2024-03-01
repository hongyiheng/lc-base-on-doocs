class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            boolean a = i > 1 && f[i - 2] && nums[i - 1] == nums[i - 2];
            boolean b = i > 2 && f[i - 3] && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3];
            boolean c = i > 2 && f[i - 3] && nums[i - 1] - nums[i - 2] == 1 && nums[i - 2] - nums[i - 3] == 1;
            f[i] = a || b || c;
        }
        return f[n];
    }
}