class Solution {

    int n, t;
    int[] f;

    public boolean dfs(int[] nums, int msk, int s) {
        if (msk == (1 << n) - 1) {
            return true;
        }
        if (f[msk] != 0) {
            return f[msk] == 1;
        }
        for (int i = 0; i < n; i++) {
            if ((msk >> i & 1) != 0) {
                continue;
            }
            if (s + nums[i] > t) {
                break;
            }
            if (dfs(nums, msk | 1 << i, (s + nums[i]) % t)) {
                f[msk] = 1;
                return true;
            }
        }
        f[msk] = -1;
        return false;
    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        int s = 0;
        for (int v : nums) {
            s += v;
        }
        if (s % k != 0) {
            return false;
        }
        t = s / k;
        f = new int[1 << n];
        Arrays.sort(nums);
        return dfs(nums, 0, 0);
    }
}