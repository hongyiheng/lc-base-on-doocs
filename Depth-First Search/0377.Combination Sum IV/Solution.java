class Solution {
    int[] memo = new int[1001];

    public int combinationSum4(int[] nums, int target) {
        Arrays.fill(memo, -1);
        return dfs(nums, target);
    }

    public int dfs(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (memo[target] != -1) {
            return memo[target];
        }
        int ans = 0;
        for (int num : nums) {
            ans += dfs(nums, target - num);
        }
        memo[target] = ans;
        return ans;
    }
}