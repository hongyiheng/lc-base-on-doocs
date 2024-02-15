class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int s = 0;
        for (int v : nums) {
            if (v % 2 == 0) {
                s += v;
            }
        }
        for (int i = 0; i < n; i++) {
            int val = queries[i][0], idx = queries[i][1];
            if (nums[idx] % 2 == 0) {
                s -= nums[idx];
            }
            nums[idx] += val;
            if (nums[idx] % 2 == 0) {
                s += nums[idx];
            }
            ans[i] = s;
        }
        return ans;
    }
}