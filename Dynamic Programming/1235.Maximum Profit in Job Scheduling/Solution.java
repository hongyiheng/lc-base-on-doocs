class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<int[]> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new int[]{startTime[i], endTime[i], profit[i]});
        }
        Collections.sort(g, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int[] cur = g.get(i - 1);
            int s = cur[0], e = cur[1], w = cur[2];
            dp[i] = Math.max(dp[i - 1], w);
            int left = 0, right = i - 1;
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (g.get(mid)[1] <= s) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (g.get(right)[1] <= s) {
                dp[i] = Math.max(dp[i], dp[right + 1] + w);
            }
        }
        return dp[n];
    }
}
