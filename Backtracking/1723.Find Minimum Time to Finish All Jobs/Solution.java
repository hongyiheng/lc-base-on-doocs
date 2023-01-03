class Solution {

    int[] jobs, cnt;
    int k, ans, n;

    public int minimumTimeRequired(int[] jobs, int k) {
        this.jobs = jobs;
        this.k = k;
        ans = Integer.MAX_VALUE;
        n = jobs.length;
        cnt = new int[k];
        dfs(0, 0, 0);
        return ans;
    }

    public void dfs(int i, int used, int cur) {
        if (cur >= ans) {
            return;
        }
        if (i == n) {
            ans = Math.min(ans, cur);
            return;
        }
        if (used < k) {
            cnt[used] += jobs[i];
            dfs(i + 1, used + 1, Math.max(cnt[used], cur));
            cnt[used] -= jobs[i];
        }
        for (int j = 0; j < used; j++) {
            cnt[j] += jobs[i];
            dfs(i + 1, used, Math.max(cnt[j], cur));
            cnt[j] -= jobs[i];
        }
    }
}