class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        int n = envelopes.length, ans = 0;
        int[] dp = new int[n], nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = envelopes[i][1];
        }
        for (int i = 0; i < n; i++) {
            int left = 0, right = ans;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (dp[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = nums[i];
            if (left == ans) {
                ans++;
            }
        }
        return ans;
    }
}
