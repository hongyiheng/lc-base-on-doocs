class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int mod = (int)1e9 + 7;
        int n = hats.size();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < hats.size(); i++) {
            for (int h : hats.get(i)) {
                mp.computeIfAbsent(h, k -> new ArrayList<>()).add(i);
            }
        }
        int[][] dp = new int[41][1 << n];
        dp[0][0] = 1;
        for (int i = 1; i < 41; i++) {
            for (int j = 0; j < 1 << n; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k : mp.getOrDefault(i, new ArrayList<>())) {
                    if ((j & (1 << k)) != 0) {
                        dp[i][j] += dp[i - 1][j ^ (1 << k)];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        return dp[40][(1 << n) - 1];
    }
}