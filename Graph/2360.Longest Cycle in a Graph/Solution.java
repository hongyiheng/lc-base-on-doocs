class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] time = new int[n];
        int cur = 1, ans = -1;
        for (int i = 0; i < n; i++) {
            if (time[i] != 0) {
                continue;
            }
            int startTime = cur, x = i;
            while (x != -1) {
                if (time[x] != 0) {
                    if (time[x] >= startTime) {
                        ans = Math.max(ans, cur - time[x]);
                    }
                    break;
                }
                time[x] = cur++;
                x = edges[x];
            }
        }
        return ans;
    }
}