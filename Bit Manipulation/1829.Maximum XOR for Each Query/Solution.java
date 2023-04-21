class Solution {

    int[] nums;
    int[] ans;
    int n, mx;

    public void dfs(int cur, int idx) {
        if (idx == n) {
            return;
        }
        cur ^= nums[idx];
        dfs(cur, idx + 1);
        ans[n - idx - 1] = cur ^ mx;
    }


    public int[] getMaximumXor(int[] nums, int maximumBit) {
        n = nums.length;
        mx = (1 << maximumBit) - 1;
        this.nums = nums;
        ans = new int[n];
        dfs(0, 0);
        return ans;
    }
}