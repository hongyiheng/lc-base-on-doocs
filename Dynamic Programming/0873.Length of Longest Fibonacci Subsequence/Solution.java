class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int t = arr[i] - arr[j];
                int idx = mp.getOrDefault(t, Integer.MAX_VALUE);
                if (idx < j) {
                    dp[i][j] = Math.max(3, dp[i][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[j][idx] + 1);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}