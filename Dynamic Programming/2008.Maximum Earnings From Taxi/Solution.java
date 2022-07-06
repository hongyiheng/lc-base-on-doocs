class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Map<Integer, List<int[]>> mp = new HashMap<>();
        for (int[] r : rides) {
            mp.computeIfAbsent(r[1], k -> new ArrayList<>()).add(r);
        }
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int[] r : mp.getOrDefault(i, new ArrayList<>())) {
                dp[i] = Math.max(dp[i], dp[r[0]] + r[1] - r[0] + r[2]);
            }
        }
        return dp[n];
    }
}