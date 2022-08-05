class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = ages[i];
            nums[i][1] = scores[i];
        }
        Arrays.sort(nums, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int[] dp = new int[n];
        dp[0] = nums[0][1];
        for (int i = 1; i < n; i++) {
            int mx = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j][1] <= nums[i][1]) {
                    mx = Math.max(mx, dp[j]);
                }
            }
            dp[i] = mx + nums[i][1];
        }
        int ans = 0;
        for (int v : dp) {
            ans = Math.max(ans, v);
        }
        return ans;
    }
}