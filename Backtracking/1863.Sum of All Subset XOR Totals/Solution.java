class Solution {
    int[] nums;

    public int dfs(int i, int v) {
        if (i == nums.length) {
            return v;
        }
        int ans = dfs(i + 1, v ^ nums[i]);
        ans += dfs(i + 1, v);
        return ans;
    }

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        return dfs(0, 0);
    }
}