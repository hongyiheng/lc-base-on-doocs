class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[][] q = new int[n][2];
        for (int i = 0; i < n; i++) {
            q[i][0] = nums[i];
            if (i > 0) {
                q[i][0] = Math.max(q[i][0], q[i - 1][0]);
            }
            q[n - i - 1][1] = nums[n - i - 1];
            if (n - i < n) {
                q[n - i - 1][1] = Math.min(q[n - i - 1][1], q[n - i][1]);
            }
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (q[i - 1][0] < nums[i] && nums[i] < q[i + 1][1]) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
}