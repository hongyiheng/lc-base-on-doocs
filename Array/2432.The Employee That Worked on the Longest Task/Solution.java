class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int mx = 0, ans = 0, last = 0;
        for (int i = 0; i < logs.length; i++) {
            int cur = logs[i][1] - last;
            if (cur > mx) {
                ans = logs[i][0];
                mx = cur;
            } else if (cur == mx && ans > logs[i][0]) {
                ans = logs[i][0];
            }
            last = logs[i][1];
        }
        return ans;
    }
}
