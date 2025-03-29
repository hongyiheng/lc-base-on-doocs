class Solution {

    int ans = -1, t = 1;
    int[] time;
    int[] edges;

    public void dfs(int x) {
        if (time[x] != 0) {
            return;
        }
        int st = t;
        while (x != -1) {
            if (time[x] != 0) {
                if (time[x] >= st) {
                    ans = Math.max(ans, t - time[x]);
                }
                break;
            } else {
                time[x] = t++;
            }
            x = edges[x];
        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        time = new int[n];
        this.edges = edges;
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        return ans;
    }
}