class Solution {

    int[][] events;
    int[][] f;
    int n;

    public int dfs(int i, int k) {
        if (i >= n || k == 0) {
            return 0;
        }
        if (f[i][k] != -1) {
            return f[i][k];
        }
        int ans1 = dfs(i + 1, k);
        int j = i + 1;
        while (j < n && events[j][0] <= events[i][1]) {
            j++;
        }
        int ans2 = events[i][2] + dfs(j, k - 1);
        f[i][k] = Math.max(ans1, ans2);
        return f[i][k];
    }

    public int maxValue(int[][] events, int k) {
        this.n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        this.events = events;
        f = new int[n][k + 1];
        for (int[] row : f) {
            Arrays.fill(row, -1);
        }
        return dfs(0, k);
    }
}