class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, ans = 0;
        int[][] f = new int[n + 1][1010];
        for (int[] r : f) {
            Arrays.fill(r, 1);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int k = nums[i] - nums[j] + 500;
                f[i][k] = Math.max(f[i][k], f[j][k] + 1);
                ans = Math.max(f[i][k], ans);
            }
        }
        return ans;
    }
}