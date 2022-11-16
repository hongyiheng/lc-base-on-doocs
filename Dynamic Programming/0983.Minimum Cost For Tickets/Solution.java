class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        Set<Integer> s = new HashSet<>();
        for (int v : days) {
            s.add(v);
        }
        for (int i = 1; i < 366; i++) {
            dp[i] = dp[i - 1];
            if (s.contains(i)) {
                dp[i] = dp[i] + costs[0];
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
            }
        }
        return dp[365];
    }
}
