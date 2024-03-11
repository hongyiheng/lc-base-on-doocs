class Solution {
    public int minimumSum(int[] nums) {
        int inf = Integer.MAX_VALUE;
        int n = nums.length;
        int[] q = new int[n];
        Arrays.fill(q, inf);
        for (int i = 1; i < n; i++) {
            q[i] = Math.min(q[i - 1], nums[i - 1]);
        }
        int ans = inf, mi = inf;
        for (int i = n - 2; i > -1; i--) {
            mi = Math.min(mi, nums[i + 1]);
            if (q[i] < nums[i] && nums[i] > mi) {
                ans = Math.min(ans, q[i] + nums[i] + mi);
            }
        }
        return ans == inf ? -1 : ans;
    }
}