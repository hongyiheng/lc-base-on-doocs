class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        int[][] cnt = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            cnt[i + 1][0] = cnt[i][0];
            cnt[i + 1][1] = cnt[i][1];
            if (s.charAt(i) == '0') {
                cnt[i + 1][0]++;
            } else {
                cnt[i + 1][1]++;
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                ans += (cnt[i][1] * (cnt[n][1] - cnt[i][1]));
            } else {
                ans += (cnt[i][0] * (cnt[n][0] - cnt[i][0]));
            }
        }
        return ans;
    }
}