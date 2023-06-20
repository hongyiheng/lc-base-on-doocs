class Solution {
    public int matrixSum(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(nums[i]);
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int mx = 0;
            for (int i = 0; i < m; i++) {
                mx = Math.max(mx, nums[i][j]);
            }
            ans += mx;
        }
        return ans;
    }
}
