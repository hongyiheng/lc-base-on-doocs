class Solution {

    int[] nums;
    int k;

    public int dfs(int i, int msk) {
        if (i == nums.length) {
            return msk != 0 ? 1 : 0;
        }
        int ans = dfs(i + 1, msk);
        for (int j = 0; j < nums.length; j++) {
            if ((msk >> j & 1) != 0 && Math.abs(nums[j] - nums[i]) == k) {
                return ans;
            }
        }
        ans += dfs(i + 1, msk | 1 << i);
        return ans;
    }

    public int beautifulSubsets(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        return dfs(0, 0);
    }
}