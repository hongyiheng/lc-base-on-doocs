class Solution {
    int[] nums;
    int n, t;
    boolean[] used;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        n = nums.length;
        Arrays.sort(nums);
        for (int v : nums) {
            t += v;
        }
        if (t % k != 0) {
            return false;
        }
        t /= k;
        used = new boolean[1 << n];
        return dfs(0, 0);
    }

    private boolean dfs(int state, int cur) {
        if (state == (1 << n) - 1) {
            return true;
        }
        if (used[state]) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if ((1 << i & state) != 0) {
                continue;
            }
            if (cur + nums[i] > t) {
                break;
            }
            if (dfs(state | 1 << i, (cur + nums[i]) % t)) {
                return true;
            }
        }
        used[state] = true;
        return false;
    }
}